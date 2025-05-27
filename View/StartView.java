package src.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartView extends JFrame {
    private JButton humanButton; // Button to select human player
    private JButton aiButton; // Button to select AI opponent

    public StartView() {
        setTitle("Select Player Type"); // Set the window title
        setSize(600, 400); // Set the size of the window (appropriate for the background image)
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen

        // Load the background image from the specified path
        ImageIcon background = new ImageIcon("C:\\Users\\hanyt\\OneDrive\\Pictures\\XO.png");

        // Create a custom JPanel to hold the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image stretched to fit the JPanel
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for better component placement

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components

        // Create the label to prompt user to select player type
        JLabel label = new JLabel("Choose Player Type:");
        label.setFont(new Font("Arial", Font.BOLD, 18)); // Set the font style and size
        label.setForeground(Color.BLACK); // Set the text color

        // Create buttons for selecting human or AI player
        humanButton = new JButton("Human Player");
        humanButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set button font size
        humanButton.setBackground(new Color(173, 216, 230)); // Set background color for the button
        humanButton.setPreferredSize(new Dimension(300, 50)); // Set button size

        aiButton = new JButton("AI Opponent");
        aiButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set button font size
        aiButton.setBackground(new Color(173, 216, 230)); // Set background color for the button
        aiButton.setPreferredSize(new Dimension(300, 50)); // Set button size

        // Add the label and buttons to the background panel with proper positioning
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(label, gbc);

        gbc.gridy = 1;
        backgroundPanel.add(humanButton, gbc);

        gbc.gridy = 2;
        backgroundPanel.add(aiButton, gbc);

        // Set the backgroundPanel as the content pane of the JFrame
        setContentPane(backgroundPanel);
        setVisible(true); // Make the window visible
    }

    // Method to add an action listener for the "Human Player" button
    public void onHumanSelected(ActionListener listener) {
        humanButton.addActionListener(listener); // Add the action listener to the button
    }

    // Method to add an action listener for the "AI Opponent" button
    public void onAISelected(ActionListener listener) {
        aiButton.addActionListener(listener); // Add the action listener to the button
    }
}


