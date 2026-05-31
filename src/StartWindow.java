import javax.swing.*;
import java.awt.*;
/**
 * Start window of the Memory Symbol Game.
 * Displays the game title and start button which begins the game.
 *
 * @author Lukáš Kulich
 */
public class StartWindow extends GameWindow{
    private GameController controller;
    /**
     * Creates the start window and initializes UI.
     *
     * @param controller reference to the game controller
     */
    public StartWindow(GameController controller) {
        super("Memory Game - Start");
        this.controller = controller;
        initUI();
    }
    /**
     * Initializes the UI components of the start window.
     * Displays title and start button.
     */
    @Override
    protected void initUI() {
        JLabel titleLabel = new JLabel("Memory Symbol Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));

        startButton.addActionListener(e -> {
            dispose();
            controller.showMemoryWindow();
        });

        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));

        panel.add(titleLabel);
        panel.add(startButton);

        add(panel);

        setVisible(true);
    }
}





