package com.amine.liveSportsData.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
@Controller
public class SoccerController {

    private final SimpMessagingTemplate messagingTemplate;
    public SoccerController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // REST API to interact with Sportradar Soccer API
    @GetMapping("/soccer/competitions")
    public ResponseEntity<?> getCompetitions(String local) {

        String apiKey = "nLv7mDeBJ47iquj1DgOmQnNRhQhVjWBrjRahqkyl";
        String url = "https://api.sportradar.com/soccer/trial/v4/"+local+"/competitions.json?api_key=" + apiKey;
        // Assuming you have an API key (replace YOUR_API_KEY with your actual key)
        System.out.println("the value of the session "+url);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        return ResponseEntity.ok(result);    }

    // WebSocket endpoint to broadcast message to all subscribers
    @MessageMapping("/send/message")
    public void sendMessage(String message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
