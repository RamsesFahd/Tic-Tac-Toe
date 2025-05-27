package src.controller;

import src.model.*;
import src.view.*;
import javax.swing.*;
import java.awt.*;

public class GameController {
    private GameModel model;
    private GameView view;
    private StartView startView;

    // A flag to indicate if the current game mode is Human vs Human
    private boolean isHumanVsHuman = false;

    // A flag to track turns: true = X's turn, false = O's turn
    private boolean xTurn = true;

    // Constructor: initializes the game controller
    public GameController() {
        this.model = new GameModel();      // Initializes the game logic/model
        this.startView = new StartView();  // Initializes the start menu interface

        // Set up the event when the player chooses Human vs Human mode
        startView.onHumanSelected(e -> {
            model.setupPlayer("human");    // Setup model for human player

            isHumanVsHuman = true;         // Enable Human vs Human mode
            xTurn = true;                  // Start the game with X player

            startView.dispose();           // Close the start screen
            launchGame();                  // Start the actual game UI
        });

        // Set up the event when the player chooses to play against AI
        startView.onAISelected(e -> {
            startView.dispose();           // Close the start screen
            showDifficultySelection();     // Show difficulty options
        });
    }

    // Display a window for selecting AI difficulty level
    private void showDifficultySelection() {
        // Create an instance of DifficultyView
        DifficultyView difficultyView = new DifficultyView();

        // Add action listeners for each button in DifficultyView
        difficultyView.onEasySelected(e -> {
            model.setupPlayer("easy");         // Set AI to easy
            isHumanVsHuman = false;            // Disable Human vs Human mode
            difficultyView.dispose();          // Close difficulty selection window
            launchGame();                      // Start the game
        });

        difficultyView.onMediumSelected(e -> {
            model.setupPlayer("medium");
            isHumanVsHuman = false;
            difficultyView.dispose();
            launchGame();
        });

        difficultyView.onHardSelected(e -> {
            model.setupPlayer("hard");
            isHumanVsHuman = false;
            difficultyView.dispose();
            launchGame();
        });
    }

    // Launch the main game board
    private void launchGame() {
        this.view = new GameView(this, model);  // Create the game UI and connect it to the controller and model
        view.showGameBoard();                   // Display the game board
    }

    // Start the game with a specific mode
    public void startGame(String mode) {
        model.setupPlayer(mode);     // Set up AI difficulty
        view.showGameBoard();        // Show the board
    }

    // Handles a player's move
    public void playerMove(int index) {

        // If playing Human vs Human
        if (isHumanVsHuman) {
            String currentSymbol = xTurn ? "X" : "O";  // Decide current player's symbol

            // If the move is valid
            if (model.makeMove(index, currentSymbol)) {
                view.updateBoard(index, currentSymbol);  // Update UI with the move

                if (model.checkWinner(currentSymbol)) {
                    view.showResult("اللاعب " + currentSymbol + " فاز!");  // Show win message
                    return;
                }

                if (model.isBoardFull()) {
                    view.showResult("تعادل!");  // Show draw message if board is full
                    return;
                }

                xTurn = !xTurn;  // Switch turn to the other player
            }

        } else {

            // If playing against AI
            if (model.makeMove(index, "X")) {  // Human plays first as "X"
                view.updateBoard(index, "X");

                if (model.checkWinner("X")) {
                    view.showResult("فزت!");  // Human wins
                    return;
                }

                if (model.isBoardFull()) {
                    view.showResult("تعادل!");  // It's a tie
                    return;
                }

                int aiMove = model.getAIMove();  // Get AI's move
                if (aiMove != -1) {
                    model.makeMove(aiMove, "O");  // AI plays as "O"
                    view.updateBoard(aiMove, "O");

                    if (model.checkWinner("O")) {
                        view.showResult("الذكاء الاصطناعي فاز!");  // AI wins
                        return;
                    }

                    if (model.isBoardFull()) {
                        view.showResult("تعادل!");  // It's a tie
                        return;
                    }
                }
            }
        }
    }

    // Reset the entire game by creating a new controller
    public void resetGame() {
        model.reset();              // Clear the model (board, etc.)
        new GameController();       // Restart everything from the beginning
    }
}


