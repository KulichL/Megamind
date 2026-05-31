import javax.swing.*;
import java.util.*;
/**
 * Main controller class that manages the game logic,
 * rounds, scoring and transitions between windows.
 *
 * @author Lukáš Kulich
 */
public class GameController {
 private final List<String> ALL_SYMBOLS = Arrays.asList(
         "@", "#", "$", "%", "&", "*", "?", "!","+"
 );

 private List<String> selectedSymbols;
 private int currentRound = 0;
 private int score = 0;

    /**
     * Starts the game by opening the start window.
     */
 void StartGame() {
     new StartWindow(this);
 }

    /**
     * Shows the memory window with randomly selected symbols
     * that the player must memorize.
     */
 public void showMemoryWindow () {
     selectedSymbols = new ArrayList<>(ALL_SYMBOLS);
     Collections.shuffle(selectedSymbols);
     selectedSymbols = selectedSymbols.subList(0,3);

     new MemoryWindow(this, selectedSymbols);
 }
    /**
     * Initializes game rounds and resets score and round counter.
     */
 public void startRounds() {
     currentRound = 0;
     score = 0;
     nextRound();
 }
    /**
     * Moves the game to the next round or finishes the game
     * if all rounds have been completed.
     */
 public void nextRound() {
     if (currentRound >= 3){
         showFinalResult();

         return;
     }

     String target = selectedSymbols.get(currentRound);
     currentRound++;
     new GameRoundWindow(this, target);
 }
    /**
     * Increments player's score when correct answer is selected.
     */
 public void incrementScore() {
     score++;
 }
    /**
     * Generates a randomized 3x3 grid of symbols for a game round.
     *
     * @return list of 9 randomly shuffled symbols
     */
 public List<String> generateGrid() {
     List<String> shuffled = new ArrayList<>(ALL_SYMBOLS);

     Collections.shuffle(shuffled);
     return shuffled.subList(0,9);

 }
    /**
     * Displays final game result and restarts the game.
     */
 private void showFinalResult() {
     JOptionPane.showMessageDialog(null, "Game Over!\nYour score: " + score + "/3");
     StartGame();
 }
}
