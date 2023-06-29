package com.example.rps;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * I put business logic to this class to make the applicaton more stuctured and JUnit testable.
 */

@Service
public class RpsService {

    public Map<String,String> composeRulemap(){
        Map<String, String> rulemap = new HashMap<>();
        rulemap.put("Rock", "Rock beats Scissors.");
        rulemap.put("Paper", "Paper beats Rock.");
        rulemap.put("Scissors", "Scissors beats Paper.");

        return rulemap;
    }

    public String getComputerChoice(){
        String[] hands = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int randomIndex = random.nextInt(hands.length);
        return hands[randomIndex];
    }

    public String play(String playerChoice, String computerChoice, boolean explain){
        boolean userWon = false;
        String explanation = "";
        if((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
                (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")) ||
                (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"))
        ){
            userWon = true;
            explanation = "You won. " + playerChoice + " beats " + computerChoice +".";
        } else if(playerChoice.equalsIgnoreCase(computerChoice)){
            explanation = "It's a tie. Computer choice: " + computerChoice +". Your choice: " + playerChoice;
        } else{
            explanation = "Computer won. " + computerChoice + " beats " + playerChoice +".";
        }

        if(explain){
            return explanation;
        }
        return String.valueOf(userWon);
    }

}
