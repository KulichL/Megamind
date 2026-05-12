import javax.swing.*;
import java.awt.*;

class MemoryWindow extends GameWindow {

    private GameController controller;
    private java.util.List<String> symbols;

    private JLabel countdownLabel;

    public MemoryWindow(GameController controller, java.util.List<String> symbols) {
        super("Memorize Symbols");
        this.controller = controller;
        this.symbols = symbols;
        initUI();
    }

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

}
