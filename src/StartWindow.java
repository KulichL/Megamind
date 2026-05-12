import javax.swing.*;
import java.awt.*;

public class StartWindow extends GameWindow{
    private GameController controller;

    public StartWindow(GameController controller) {
        super("Memory Game - Start");
        this.controller = controller;
        initUI();
    }

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
    }
}

