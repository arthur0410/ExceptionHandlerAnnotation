package com.example.exceptionhandler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Component
public class Scheduler {

    @Handled
    @Scheduled(fixedDelay = 1000000, initialDelay = 10)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        throw new RuntimeException();
    }
}
