package src.view;

import src.controller.GameController;
import src.model.GameModel;

import javax.swing.*;
import java.awt.*;

public class GameView {
    private GameController controller; // Controller to handle game logic
    private GameModel model;           // Model to represent the current state of the game
    private JFrame frame;              // The main frame for the game window
    private JButton[] buttons;         // Array of buttons representing each cell in the TicTacToe board

    // Constructor to initialize the controller and model
    public GameView(GameController controller, GameModel model) {
        this.controller = controller;
        this.model = model;
    }

    // Method to display the TicTacToe game board
    public void showGameBoard() {
        frame = new JFrame("TicTacToe"); // Create a JFrame for the game
        frame.setSize(600, 600); // Set window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        frame.setLocationRelativeTo(null); // Center the window on the screen

        // Load the background image
        ImageIcon background = new ImageIcon("C:\\Users\\hanyt\\OneDrive\\Pictures\\XO.png");

        // Create a custom JPanel to paint the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image stretched to fit the panel
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for better component positioning

        // Create a JPanel for the TicTacToe board (3x3 grid)
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        boardPanel.setOpaque(false); // Set panel to be transparent so the background shows
        boardPanel.setPreferredSize(new Dimension(400, 400)); // Set the size of the board panel

        // Create 9 buttons (one for each TicTacToe cell)
        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton(""); // Initialize each button with no text
            btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40)); // Set the font for the button
            btn.setBackground(new Color(173, 216, 230)); // Set a background color for the button

            final int idx = i;
            // Add action listener to handle player moves
            btn.addActionListener(e -> {
                if (btn.getText().equals("")) { // Check if the cell is empty
                    controller.playerMove(idx); // Call the controller to process the move
                }
            });

            buttons[i] = btn; // Add the button to the array
            boardPanel.add(btn); // Add the button to the board panel
        }

        // Add the board panel to the background panel
        backgroundPanel.add(boardPanel);
        frame.setContentPane(backgroundPanel); // Set the background panel as the content pane
        frame.setVisible(true); // Make the window visible
    }

    // Method to update the board with the player's symbol (X or O)
    public void updateBoard(int index, String symbol) {
        buttons[index].setText(symbol); // Set the button text to the player's symbol
    }

    // Method to display the result screen after the game ends
    public void showResult(String message) {
        frame.dispose(); // Close the current game window

        // Create a new FinalResultView to display the game result
        FinalResultView resultView = new FinalResultView(message);
        resultView.onPlayAgain(e -> {
            resultView.dispose(); // Close the result screen
            controller.resetGame(); // Reset the game state
        });
        resultView.onExit(e -> {
            System.exit(0); // Exit the application
        });
    }
}




