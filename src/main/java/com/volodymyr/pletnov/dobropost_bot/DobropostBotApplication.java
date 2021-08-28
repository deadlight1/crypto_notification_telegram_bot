package com.volodymyr.pletnov.dobropost_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class DobropostBotApplication  extends SpringBootServletInitializer {


    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(DobropostBotApplication.class, args);
    }

}
