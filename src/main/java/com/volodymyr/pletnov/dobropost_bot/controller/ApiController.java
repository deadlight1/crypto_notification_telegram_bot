package com.volodymyr.pletnov.dobropost_bot.controller;

import com.volodymyr.pletnov.dobropost_bot.DobroBot;
import com.volodymyr.pletnov.dobropost_bot.model.NotificationDto;
import com.volodymyr.pletnov.dobropost_bot.model.NotificationToUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final DobroBot dobroBot;

    @PostMapping("/api/notification")
    public NotificationToUserRequest notification(@RequestBody NotificationToUserRequest notification) {
        return dobroBot.send(notification);
    }
}
