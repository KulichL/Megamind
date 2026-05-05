
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Main class that starts the application
 */
public class MemoryGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameController().startGame();
        });
    }
}
