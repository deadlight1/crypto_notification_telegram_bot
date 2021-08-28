package com.volodymyr.pletnov.dobropost_bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface FacadeService {
    SendMessage delegateTo(Update update);
}
