import javax.swing.*;
import java.util.*;

public class GameController {
 private final List<String> ALL_SYMBOLS = Arrays.asList(
         "★", "▲", "●", "■", "◆", "♥", "☀", "☂", "♣"
 );

 private List<String> selectedSymbols;
 private int currentRound = 0;
 private int score = 0;

 void StartGame() {
     new StartWindow(this);
 }

 public void showMemoryWindow () {
     selectedSymbols = new ArrayList<>(ALL_SYMBOLS);
     Collections.shuffle(selectedSymbols);
     selectedSymbols = selectedSymbols.subList(0,3);

     new MemoryWindow(this, selectedSymbols);
 }

 public void startRounds() {
     currentRound = 0;
     score = 0;
     nextRound();
 }

 public void nextRound() {
     if (currentRound >= 3){
         showFinalResult();

         return;
     }

     String target = selectedSymbols.get(currentRound);
     currentRound++;
     new GameRoundWindow(this, target);
 }

 public void incrementScore() {
     score++;
 }

 public List<String> generateGrid() {
     List<String> shuffled = new ArrayList<>(ALL_SYMBOLS);

     Collections.shuffle(shuffled);
     return shuffled.subList(0,9);

 }

 private void showFinalResult() {
     JOptionPane.showMessageDialog(null, "Game Over!\nYour score: " + score + "/3");
     StartGame();
 }
}
