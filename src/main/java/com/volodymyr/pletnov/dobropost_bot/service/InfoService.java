package com.volodymyr.pletnov.dobropost_bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface InfoService {
    SendMessage generalInfo(Long chatId);
}
