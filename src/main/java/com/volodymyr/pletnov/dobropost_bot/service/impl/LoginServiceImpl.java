package com.volodymyr.pletnov.dobropost_bot.service.impl;

import com.volodymyr.pletnov.dobropost_bot.model.LoginRequestDto;
import com.volodymyr.pletnov.dobropost_bot.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static org.springframework.http.HttpMethod.POST;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final RestTemplate restTemplate;

    @Override
    public SendMessage login(Long chatId, String messageText) {
        try {
            LoginRequestDto credentials = getCredentialsFromToken(messageText, chatId);
            HttpEntity httpEntity = new HttpEntity<>(credentials);
            if (HttpStatus.CREATED.equals(restTemplate.exchange("http://159.253.19.31:8080/ClientOffice/wsf/free/botApi/login"
                    , POST
                    , httpEntity
                    , Void.class).getStatusCode())) {
                return new SendMessage(chatId, "Всё прошло успешно! Вскоре начнёте получать уведомления!");
            } else {
                return new SendMessage(chatId, "Неверный логин или пароль");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new SendMessage(chatId, "Что-то пошло не так!");
        }
    }

    private LoginRequestDto getCredentialsFromToken(String token, Long chatId) {
        log.info("Token: " + token);
        String email = token.split(":")[0];
        String password = token.substring(token.lastIndexOf(":") + 1);
        LoginRequestDto loginRequestDto = new LoginRequestDto(chatId, email, password);
        log.info("CredentialsDto: " + loginRequestDto);
        return loginRequestDto;
    }
}
