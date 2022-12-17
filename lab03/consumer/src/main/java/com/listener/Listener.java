package com.listener;

import com.entities.Reading;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.ConsumerApplication.QUEUE_NAME;

@Slf4j
@EnableRabbit
@Component
public class Listener {
    @Autowired
    private Repository repository;

    @RabbitListener(queues = QUEUE_NAME)
    public void receive(String message) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

       try {
           Reading reading = gson.fromJson(message, Reading.class);
           repository.save(reading);
           log.info("Save", reading);

       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

    }
}
