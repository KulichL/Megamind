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



        gridSymbols = controller.generateGrid();

        for (int i = 0; i < gridSymbols.size(); i++) {
            String symbol = gridSymbols.get(i);
            JButton button = new JButton(symbol);

            int index = i;


            gridPanel.add(button);
        }

        add(gridPanel, BorderLayout.CENTER);
        setVisible(true);
    }

        try {
            if (gridSymbols.get(index).equals(targetSymbol)) {
                controller.incrementScore();
            }
        }

        dispose();
        controller.nextRound();
    }
}
