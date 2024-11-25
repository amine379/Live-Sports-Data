package com.amine.liveSportsData.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
@Controller
public class SoccerController {

    private final SimpMessagingTemplate messagingTemplate;
    @Value("${api.sportradar.key}")
    private String apiKey;
    @Value("${api.sportradar.url.competitions}")
    private String globalUrl;

    public SoccerController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // REST API to interact with Sportradar Soccer API
    @GetMapping("/soccer/competitions")
    public ResponseEntity<?> getCompetitions() {
//if( language=="" || language.trim().isEmpty())
//{
//    return  ResponseEntity.badRequest().body("Invalid local parametrre");
//}
        globalUrl +=".json?api_key=" + apiKey;
        // Assuming you have an API key (replace YOUR_API_KEY with your actual key)
        System.out.println("the value of the session "+globalUrl);

        RestTemplate restTemplate = new RestTemplate();
        try {
            String result = restTemplate.getForObject(globalUrl, String.class);

            return ResponseEntity.ok(result);
        }
      catch (HttpClientErrorException | HttpServerErrorException e){
          return ResponseEntity.status(e.getStatusCode()).body("Error: " + e.getMessage());
      }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error: " + e.getMessage());
        }

    }
@GetMapping("soccer/competitions/{countryCode}")
    public ResponseEntity<?> getCompetitionsByCountry(@PathVariable String countryCode){
if(countryCode==null || countryCode.trim().isEmpty()){
    return ResponseEntity.badRequest().body("Invalid Request Missing Country Code");
}
globalUrl+="";
return null;
    }

    // WebSocket endpoint to broadcast message to all subscribers
    @MessageMapping("/send/message")
    public void sendMessage(String message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
