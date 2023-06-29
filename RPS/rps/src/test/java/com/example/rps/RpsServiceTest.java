package com.example.rps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RpsServiceTest {
    private RpsService rpsService;

    @Autowired
    public RpsServiceTest(RpsService rpsService) {
        this.rpsService = rpsService;
    }

    /*
     * TIES
     */
    @Test
    public void testBothRockWithExplain(){
        String choice = "Rock";
        String actual = rpsService.play("Rock", "Rock",true);
        String expected = "It's a tie. Computer choice: " + choice +". Your choice: " + choice;
        assertEquals(expected, actual);
    }

    @Test
    public void testBothRockWithOutExplain(){
        String actual = rpsService.play("Rock", "Rock",false);
        assertEquals("false", actual);
    }

    @Test
    public void testBothPaperWithExplain(){
        String choice = "Paper";
        String actual = rpsService.play(choice, choice,true);
        String expected = "It's a tie. Computer choice: " + choice +". Your choice: " + choice;
        assertEquals(expected, actual);
    }

    @Test
    public void testBothPaperWithOutExplain(){
        String actual = rpsService.play("Paper", "Paper",false);
        assertEquals("false", actual);
    }

    @Test
    public void testBothScissorsWithExplain(){
        String choice = "Scissors";
        String actual = rpsService.play(choice, choice,true);
        String expected = "It's a tie. Computer choice: " + choice +". Your choice: " + choice;
        assertEquals(expected, actual);
    }

    @Test
    public void testBothScissorsWithOutExplain(){
        String actual = rpsService.play("Scissors", "Scissors",false);
        assertEquals("false", actual);
    }

    /*
     * USER WINS
     */
    @Test
    public void testUserWinsByRockWithExplain(){
        String actual = rpsService.play("Rock", "Scissors", true);
        String expected = "You won. Rock beats Scissors.";
        assertEquals(expected, actual);
    }

    @Test
    public void testUserWinsByRockWithOutExplain(){
        String actual = rpsService.play("Rock", "Scissors", false);
        assertEquals("true", actual);
    }

    @Test
    public void testUserWinsByPaperWithExplain(){
        String actual = rpsService.play("Paper", "Rock", true);
        String expected = "You won. Paper beats Rock.";
        assertEquals(expected, actual);
    }

    @Test
    public void testUserWinsByPaperWithOutExplain(){
        String actual = rpsService.play("Paper", "Rock", false);
        assertEquals("true", actual);
    }

    @Test
    public void testUserWinsByScissorsWithExplain(){
        String actual = rpsService.play("Scissors", "Paper", true);
        String expected = "You won. Scissors beats Paper.";
        assertEquals(expected, actual);
    }

    @Test
    public void testUserWinsByScissorsWithOutExplain(){
        String actual = rpsService.play("Scissors", "Paper", false);
        assertEquals("true", actual);
    }

    /*
     * COMPUTER WINS
     */
    @Test
    public void testComputerWinsByRockWithExplain(){
        String actual = rpsService.play("Scissors", "Rock", true);
        String expected = "Computer won. Rock beats Scissors.";
        assertEquals(expected, actual);
    }

    @Test
    public void testComputerWinsByRockWithOutExplain(){
        String actual = rpsService.play("Scissors", "Rock", false);
        assertEquals("false", actual);
    }

    @Test
    public void testComputersWinsByPaperWithExplain(){
        String actual = rpsService.play("Rock","Paper", true);
        String expected = "Computer won. Paper beats Rock.";
        assertEquals(expected, actual);
    }

    @Test
    public void testComputersWinsByPaperWithOutExplain(){
        String actual = rpsService.play("Rock","Paper", false);
        assertEquals("false", actual);
    }

    @Test
    public void testComputerWinsByScissorsWithExplain(){
        String actual = rpsService.play("Paper", "Scissors", true);
        String expected = "Computer won. Scissors beats Paper.";
        assertEquals(expected, actual);
    }

    @Test
    public void testComputerWinsByScissorsWithOutExplain(){
        String actual = rpsService.play("Paper", "Scissors", false);
        assertEquals("false", actual);
    }

}