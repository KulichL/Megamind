import javax.swing.*;
import java.awt.*;

class GameRoundWindow extends GameWindow {

    private GameController controller;
    private String targetSymbol;
    private java.util.List<String> gridSymbols;
    private JLabel timerLabel;
    private  Timer roundTimer;
    private int remainingTime = 10;

    public GameRoundWindow(GameController controller, String targetSymbol) {
        super("Round");
        this.controller = controller;
        this.targetSymbol = targetSymbol;
        initUI();
    }

    @Override
    protected void initUI() {
        setLayout(new BorderLayout());

        setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        JLabel instructionLabel = new JLabel(
                "Find this symbol: " + targetSymbol,
                SwingConstants.CENTER
        );

        instructionLabel.setFont(new Font("Arial", Font.BOLD, 22));

        timerLabel = new JLabel(
                "Remaining time: 10",
                SwingConstants.CENTER
        );

        timerLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        topPanel.add(instructionLabel);
        topPanel.add(timerLabel);

        add(topPanel, BorderLayout.NORTH);

        // Grid panel
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 5, 5));

        gridSymbols = controller.generateGrid();

        for (int i = 0; i < gridSymbols.size(); i++) {

            String symbol = gridSymbols.get(i);

            JButton button = new JButton(symbol);

            button.setFont(new Font("Arial", Font.BOLD, 28));

            int index = i;

            button.addActionListener(e -> handleSelection(index));

            gridPanel.add(button);
        }

        add(gridPanel, BorderLayout.CENTER);

        setVisible(true);

        startRoundTimer();
    }

    /**
     * Starts round timer
     */
    private void startRoundTimer() {

        roundTimer = new Timer(1000, null);

        roundTimer.addActionListener(e -> {

            remainingTime--;

            timerLabel.setText("Remaining time: " + remainingTime);

            if (remainingTime <= 0) {

                roundTimer.stop();

                JOptionPane.showMessageDialog(
                        this,
                        "Time is over!"
                );

                dispose();

                controller.nextRound();
            }
        });

        roundTimer.start();
    }

    /**
     * Handles button click
     */
    private void handleSelection(int index) {

        try {

            roundTimer.stop();

            if (gridSymbols.get(index).equals(targetSymbol)) {

                controller.incrementScore();

                JOptionPane.showMessageDialog(
                        this,
                        "Correct!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Wrong symbol!"
                );
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unexpected error occurred.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        dispose();

        controller.nextRound();
    }
}

