package com.volodymyr.pletnov.dobropost_bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    @JsonProperty("chatId")
    private Long chatId;
    private String email;
    private String password;
}
