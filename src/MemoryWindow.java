import javax.swing.*;
import java.awt.*;
/**
 * Window that displays symbols for the player to memorize.
 * After a short countdown, the window automatically closes
 * and the game continues to the next phase.
 *
 * @author Lukáš Kulich
 */
class MemoryWindow extends GameWindow {

    private GameController controller;
    private java.util.List<String> symbols;

    private JLabel countdownLabel;
    /**
     * Creates a new memory window.
     *
     * @param controller reference to the game controller
     * @param symbols list of symbols to memorize
     */
    public MemoryWindow(GameController controller, java.util.List<String> symbols) {
        super("Memorize Symbols");
        this.controller = controller;
        this.symbols = symbols;
        initUI();
    }
    /**
     * Initializes UI components of the memory window.
     */
    @Override
    protected void initUI() {
        setLayout(new BorderLayout());

        JLabel symbolLabel = new JLabel(
                String.join("   ", symbols),
                SwingConstants.CENTER
        );

        symbolLabel.setFont(new Font("Arial", Font.BOLD, 40));

        countdownLabel = new JLabel(
                "Time left: 5",
                SwingConstants.CENTER
        );

        countdownLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        add(symbolLabel, BorderLayout.CENTER);
        add(countdownLabel, BorderLayout.SOUTH);

        setVisible(true);
        startCountdown();
    }
    /**
     * Starts countdown timer that controls how long
     * the symbols are shown to the player.
     */

    private void startCountdown() {

        Timer timer = new Timer(1000, null);

        final int[] seconds = {5};

        timer.addActionListener(e -> {

            seconds[0]--;

            countdownLabel.setText("Time left: " + seconds[0]);

            if (seconds[0] <= 0) {
                timer.stop();

                dispose();

                controller.startRounds();
            }
        });
        timer.start();
    }
}

