package com.volodymyr.pletnov.dobropost_bot.util;


import com.volodymyr.pletnov.dobropost_bot.model.CurrencyRatesRequestDto;
import com.volodymyr.pletnov.dobropost_bot.model.CurrencyResponseDto;
import com.volodymyr.pletnov.dobropost_bot.model.Quote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchedulerHelper {

    private final RestTemplate restTemplate;
    @Value("${spring.currency.api.key}")
    private String accessKey;
    private List<String> baseCurrencies = new ArrayList<>(Arrays.asList("USDRUB", "USDCNY", "USDEUR"));

    //86400000 = 24 hours
    @Scheduled(fixedDelayString = "86400000")
    public void callCurrencyRateApiAndSendItToDobropost() {
        CurrencyRatesRequestDto req = new CurrencyRatesRequestDto();
        CurrencyResponseDto resBody = restTemplate
                .getForEntity("http://api.currencylayer.com/live?access_key=" + accessKey, CurrencyResponseDto.class)
                .getBody();

        log.info("RESPONSE: " + resBody);

        if (resBody.isSuccess()
                && resBody.getSource() != null && resBody.getSource().equals("USD")) {

            List<Quote> currenciesRates = resBody.getQuotes().entrySet().stream()
                    .filter(e -> baseCurrencies.contains(e.getKey()))
                    .map(e -> new Quote(StringUtils.substringAfter(e.getKey(), "USD"), e.getValue()))
                    .collect(toList());

            req.setQuotes(currenciesRates);
            log.info("REQUEST: " + req.toString());

            restTemplate.postForEntity("http://159.253.19.31:8080/ClientOffice/wsf/free/api/currencies/rates", req, Void.class);
        }
    }
}
