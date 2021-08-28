package com.volodymyr.pletnov.dobropost_bot.service.impl;

import com.volodymyr.pletnov.dobropost_bot.service.FacadeService;
import com.volodymyr.pletnov.dobropost_bot.service.InfoService;
import com.volodymyr.pletnov.dobropost_bot.service.LoginService;
import com.volodymyr.pletnov.dobropost_bot.service.StartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Service
@RequiredArgsConstructor
public class FacadeServiceImpl implements FacadeService {

    private final StartService startService;
    private final LoginService loginService;
    private final InfoService infoService;

    @Override
    public SendMessage delegateTo(Update update) {
        log.info(update.toString());
        String messageText = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        if (messageText.equals("/start")) {
            return startService.start(chatId);
        } else if (messageText.contains(":")) {
            return loginService.login(chatId, messageText);
        } else if (messageText.equals("Инфо")) {
            return infoService.generalInfo(chatId);
        } else {
            return new SendMessage(chatId, "Некоректная команда!");
        }
    }


}
