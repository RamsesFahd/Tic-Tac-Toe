package src.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FinalResultView extends JFrame {
    private JLabel resultLabel; // Label to display the result message (e.g., "Player X wins!")
    private JButton replayButton; // Button to restart the game
    private JButton exitButton; // Button to exit the game

    // Constructor to create and display the final result window
    public FinalResultView(String resultText) {
        setTitle("Game Result"); // Set the title of the window
        setSize(600, 400); // Set window size large enough to fit the background
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen

        // Load the background image
        ImageIcon background = new ImageIcon("C:\\Users\\hanyt\\OneDrive\\Pictures\\XO.png");

        // Create a custom JPanel to paint the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image stretched to fit the panel size
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout()); // Use GridBagLayout to manage component positioning

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components

        // Create and style the result label
        resultLabel = new JLabel(resultText);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font size and style
        resultLabel.setForeground(new Color(100, 149, 237)); // Set the text color
        gbc.gridx = 0; // Set the position of the label
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across 2 columns
        backgroundPanel.add(resultLabel, gbc); // Add label to the panel

        // Create and style the "Play Again" button
        replayButton = new JButton("Play Again");
        replayButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font for the button
        replayButton.setBackground(new Color(173, 216, 230)); // Set background color
        replayButton.setPreferredSize(new Dimension(130, 40)); // Set button size
        gbc.gridy = 1; // Set the position for the replay button
        gbc.gridwidth = 1; // Set the button width to 1
        gbc.gridx = 0;
        backgroundPanel.add(replayButton, gbc); // Add button to the panel

        // Create and style the "Exit" button
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font for the button
        exitButton.setBackground(new Color(173, 216, 230)); // Set background color
        exitButton.setPreferredSize(new Dimension(130, 40)); // Set button size
        gbc.gridx = 1; // Set the position for the exit button
        backgroundPanel.add(exitButton, gbc); // Add button to the panel

        setContentPane(backgroundPanel); // Set the custom background panel as the content pane
        setVisible(true); // Make the window visible
    }

    // Method to assign a listener to the "Play Again" button
    public void onPlayAgain(ActionListener listener) {
        replayButton.addActionListener(listener); // Add action listener for the replay button
    }

    // Method to assign a listener to the "Exit" button
    public void onExit(ActionListener listener) {
        exitButton.addActionListener(listener); // Add action listener for the exit button
    }
}

