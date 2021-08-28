package com.volodymyr.pletnov.dobropost_bot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties
public class Quote {
    private String rate;
    private String value;
}
