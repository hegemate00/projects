package com.example.rps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RpsController {

    @Autowired
    private RpsService rpsService;

    @GetMapping("/rules")
    public ResponseEntity<String> getRules(){
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(rpsService.composeRulemap());
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(json);
    }

    @PostMapping("/play")
    public ResponseEntity<String> play(@RequestBody String playerChoice,
                       @RequestParam(value = "explain", defaultValue = "false") boolean explain){
        System.out.println(explain);
        String computerChoice = rpsService.getComputerChoice();
        String result = rpsService.play(playerChoice, computerChoice, explain);

        return ResponseEntity.ok(result);
    }
}
