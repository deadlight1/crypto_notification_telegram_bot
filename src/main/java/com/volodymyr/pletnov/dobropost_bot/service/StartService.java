package com.volodymyr.pletnov.dobropost_bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface StartService {
    SendMessage start(Long chatId);
}
