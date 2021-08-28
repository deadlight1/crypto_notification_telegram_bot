package com.volodymyr.pletnov.dobropost_bot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class CurrencyResponseDto {
    private boolean success;
    private String terms;
    private String privacy;
    private String source;
    private Map<String,String> quotes;
}
