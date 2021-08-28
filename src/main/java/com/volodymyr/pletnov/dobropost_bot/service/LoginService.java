package com.volodymyr.pletnov.dobropost_bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface LoginService {
    SendMessage login(Long chatId, String messageText);
}
