import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * Main class of the Memory Symbol Game application.
 * This class contains the main method and starts the game.
 *
 * @author Lukáš Kulich
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Entry point of the application.
         * Creates the game controller and starts the game
         * on the Swing Event Dispatch Thread.
         *
         * @param args command-line arguments (not used)
         */
        SwingUtilities.invokeLater(() -> {
            GameController controller = new GameController();
            controller.StartGame();
        });


    }
}