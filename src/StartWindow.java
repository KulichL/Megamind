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
        JButton startButton = new JButton("Start Game");

        startButton.addActionListener(e -> {
            dispose();
            controller.showMemoryWindow();
        });

        setLayout(new GridBagLayout());
        add(startButton);
        setVisible(true);
    }
}

