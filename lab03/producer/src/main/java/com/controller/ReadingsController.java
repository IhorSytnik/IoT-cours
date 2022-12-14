package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/readings")
public class ReadingsController {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Exchange exchange;

    @PostMapping("/createReadings")
    public String createReading(@RequestBody String message) {
        System.out.println(message);
        template.convertAndSend(exchange.getName(), "readings.created", message);
        return "Success";
    }
}
