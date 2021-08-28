package com.volodymyr.pletnov.dobropost_bot.service.impl;

import com.volodymyr.pletnov.dobropost_bot.service.StartService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static com.volodymyr.pletnov.dobropost_bot.util.Helper.createDefaultReplyKeyboardMarkup;

@Service
public class StartServiceImpl implements StartService {

    @Override
    public SendMessage start(Long chatId) {
        SendMessage sendMessage = new SendMessage(chatId
                , "Добро пожаловать в Dobropost!\n" +
                "Чтобы начать получать уведомления введите ваш email и пароль.\n\n" +
                "В формате YOUR_USERNAME:YOUR_PA$$W0RD\n" +
                "Пример: test@gmail.com:myTestPa$$w0rd\n\n" +
                "Если вы ещё не зарегистрированы перейдите по ссылке: https://sklad.dobropost.com"+
                "\n Your chat id :"+chatId);
        sendMessage.setReplyMarkup(createDefaultReplyKeyboardMarkup());
        return sendMessage;
    }
}
