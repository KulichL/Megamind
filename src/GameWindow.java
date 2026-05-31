import javax.swing.*;
/**
 * Abstract base class for all game windows in the application.
 * Provides basic JFrame configuration and enforces UI initialization
 * in subclasses via the initUI() method.
 *
 * @author Lukáš Kulich
 */
abstract class GameWindow extends JFrame {
    /**
     * Creates a new game window with basic configuration.
     *
     * @param title title of the window
     */
    public GameWindow(String title) {
        setTitle(title);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initializes the user interface components.
     * Must be implemented by all subclasses.
     */
    protected abstract void initUI();
}

