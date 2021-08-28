package com.volodymyr.pletnov.dobropost_bot;

import com.volodymyr.pletnov.dobropost_bot.model.NotificationDto;
import com.volodymyr.pletnov.dobropost_bot.model.NotificationToUserRequest;
import com.volodymyr.pletnov.dobropost_bot.service.FacadeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

@Component
@Getter
@Setter
public class DobroBot extends TelegramLongPollingBot {

    private FacadeService facadeService;
    private String botUsername;
    private String botToken;

    public DobroBot(DefaultBotOptions options) {
        super(options);
    }

    public NotificationToUserRequest send(NotificationToUserRequest notificationDto) {
        try {
            execute(new SendMessage("595083283", notificationDto.toString()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return notificationDto;
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage message = facadeService.delegateTo(update);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setFacadeService(FacadeService facadeService) {
        this.facadeService = facadeService;
    }
}
