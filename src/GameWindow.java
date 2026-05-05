import javax.swing.*;

abstract class GameWindow extends JFrame {

    public GameWindow(String title) {
        setTitle(title);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected abstract void initUI();
}

