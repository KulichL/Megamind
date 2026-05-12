import javax.swing.*;
import java.awt.*;

class GameRoundWindow extends GameWindow {

    private GameController controller;
    private String targetSymbol;
    private java.util.List<String> gridSymbols;

    public GameRoundWindow(GameController controller, String targetSymbol) {
        super("Round");
        this.controller = controller;
        this.targetSymbol = targetSymbol;
        initUI();
    }

    @Override
    protected void initUI() {
        setLayout(new BorderLayout());

        JLabel instruction = new JLabel("Find symbol: " + targetSymbol, SwingConstants.CENTER);
        instruction.setFont(new Font("Arial", Font.BOLD, 16));
        add(instruction, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(3, 3));

        gridSymbols = controller.generateGrid();

        for (int i = 0; i < gridSymbols.size(); i++) {
            String symbol = gridSymbols.get(i);
            JButton button = new JButton(symbol);

            int index = i;

            button.addActionListener(e -> handleClick(index));

            gridPanel.add(button);
        }

        add(gridPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void handleClick(int index) {
        try {
            if (gridSymbols.get(index).equals(targetSymbol)) {
                controller.incrementScore();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        dispose();
        controller.nextRound();
    }
}
