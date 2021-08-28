package com.volodymyr.pletnov.dobropost_bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRatesRequestDto {
    private List<Quote> quotes;
}
