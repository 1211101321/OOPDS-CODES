import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoBoomGUI {
    private JFrame frame;
    private JTextArea textArea;
    private JButton playButton;
    private MainGame mainGame; // Reference to MainGame class

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GoBoomGUI gui = new GoBoomGUI();
            gui.createAndShowGUI();
        });
    }

    void createAndShowGUI() {
        frame = new JFrame("GoBoom Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create GUI components
        textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        playButton = new JButton("Play");

        // Play button implementation
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call startGame() on mainGame object
                mainGame.startGame(); 
            }
        });

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playButton);

        // Set the layout of the frame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set the size and visibility of the frame
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);

        // Create an instance of MainGame
        mainGame = new MainGame();

        // Call your existing logic here to update the text area
        updateTextArea("          Welcome to GoBoom!          ");
        updateTextArea("     Click Play to start the game.    ");
        updateTextArea("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        updateTextArea("Game will begin on your console panel.");
        updateTextArea("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }

    private void updateTextArea(String message) {
        textArea.append(message + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
