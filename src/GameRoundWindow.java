import javax.swing.*;
import java.awt.*;
/**
 * Window representing a single round of the memory game.
 * Displays a 3x3 grid of symbols where the player must find
 * the target symbol.
 *
 * @author Lukáš Kulich
 */
class GameRoundWindow extends GameWindow {
private GameController controller;
private String targetSymbol;
private java.util.List<String> gridSymbols;
    /**
     * Creates a new game round window.
     *
     * @param controller reference to the game controller
     * @param targetSymbol symbol that the player must find
     */
public GameRoundWindow(GameController controller, String targetSymbol) {
    super("Round");
    this.controller = controller;
    this.targetSymbol = targetSymbol;
    initUI();
}
    /**
     * Initializes the UI components for the game round.
     * Creates a 3x3 grid of buttons representing symbols.
     */
@Override
protected void initUI() {
    setLayout(new BorderLayout());

//    JLabel instruction = new JLabel("Find symbol: " + targetSymbol, SwingConstants.CENTER);
//    instruction.setFont(new Font("Arial", Font.BOLD, 16));
//    add(instruction, BorderLayout.NORTH);

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
    /**
     * Handles player click on a symbol button.
     * Checks if the selected symbol matches the target symbol.
     *
     * @param index index of clicked button in grid
     */
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

