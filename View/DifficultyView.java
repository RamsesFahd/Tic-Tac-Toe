package src.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DifficultyView extends JFrame {
    private JButton easyButton; // Button for selecting easy difficulty
    private JButton mediumButton; // Button for selecting medium difficulty
    private JButton hardButton; // Button for selecting hard difficulty

    // Constructor to initialize and set up the DifficultyView window
    public DifficultyView() {
        setTitle("Choose Difficulty"); // Set the title of the window
        setSize(600, 400); // Set window size large enough to fit the background
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Close the application when the window is closed
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

        // Create and style the label for the title
        JLabel label = new JLabel("Choose Difficulty:");
        label.setHorizontalAlignment(JLabel.CENTER); // Center align the label
        label.setFont(new Font("Arial", Font.BOLD, 30)); // Set font size and style
        label.setForeground(Color.BLACK); // Set the text color

        // Create buttons for each difficulty level
        easyButton = new JButton("Easy");
        mediumButton = new JButton("Medium");
        hardButton = new JButton("Hard");

        // Set the style for all the buttons
        JButton[] buttons = { easyButton, mediumButton, hardButton };
        for (JButton button : buttons) {
            button.setBackground(new Color(173, 216, 230)); // Set background color for buttons
            button.setFont(new Font("Arial", Font.BOLD, 16)); // Set font for buttons
            button.setPreferredSize(new Dimension(300, 50)); // Set button size
        }

        // Add the components to the background panel with specific grid positions
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(label, gbc); // Add the label to the panel

        gbc.gridy = 1;
        backgroundPanel.add(easyButton, gbc); // Add easy button to the panel

        gbc.gridy = 2;
        backgroundPanel.add(mediumButton, gbc); // Add medium button to the panel

        gbc.gridy = 3;
        backgroundPanel.add(hardButton, gbc); // Add hard button to the panel

        // Set the custom background panel as the content pane of the window
        setContentPane(backgroundPanel);
        setVisible(true); // Make the window visible
    }

    // Method to assign a listener to the "Easy" difficulty button
    public void onEasySelected(ActionListener listener) {
        easyButton.addActionListener(listener); // Add action listener for the easy button
    }

    // Method to assign a listener to the "Medium" difficulty button
    public void onMediumSelected(ActionListener listener) {
        mediumButton.addActionListener(listener); // Add action listener for the medium button
    }

    // Method to assign a listener to the "Hard" difficulty button
    public void onHardSelected(ActionListener listener) {
        hardButton.addActionListener(listener); // Add action listener for the hard button
    }
}




