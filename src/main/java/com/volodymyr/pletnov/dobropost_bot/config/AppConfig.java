package com.volodymyr.pletnov.dobropost_bot.config;

import com.volodymyr.pletnov.dobropost_bot.DobroBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@EnableScheduling
@Configuration
public class AppConfig {
    @Bean
    public DobroBot dobroBot() {
        DefaultBotOptions options = ApiContext
                .getInstance(DefaultBotOptions.class);

        DobroBot dobroBot = new DobroBot(options);
        dobroBot.setBotUsername("@crypto_profit_notification_bot");
        dobroBot.setBotToken("1991038010:AAFKsOGLOvnTK5D6EoPBe73yNcmxHugAQVY");
        return dobroBot;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
