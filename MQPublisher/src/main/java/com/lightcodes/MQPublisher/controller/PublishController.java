package com.lightcodes.MQPublisher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lightcodes.messaging.MesssagePublisher;

@RestController
public class PublishController {
    
    private MesssagePublisher publisher;

    public PublishController(MesssagePublisher publisher) {
        super();
        this.publisher = publisher;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> getMethodName(@RequestParam String param) {
        publisher.PublishMessage(param);
        return ResponseEntity.ok("Message Sent");
    }
    

}
