package src.model;

import java.util.*;

// This class represents the core logic and data (the "model") of the game.
public class GameModel {

    // The game board is represented as a 1D array of 9 strings (3x3 grid)
    private String[] board;

    // The player object (could be AI or human depending on game mode)
    private Player player;

    // Constructor: initializes the board with empty strings
    public GameModel() {
        board = new String[9];          // Create a 9-cell board
        Arrays.fill(board, "");         // Fill all cells with empty strings
    }

    // Sets up the player based on the chosen mode (e.g., "easy", "medium", "human", etc.)
    public void setupPlayer(String mode) {
        player = PlayerFactory.createPlayer(mode);  // Delegates creation to a factory class
    }

    // Tries to make a move at the given index with the provided symbol (e.g., "X" or "O")
    public boolean makeMove(int index, String symbol) {
        if (board[index].equals("")) {   // Check if the cell is empty
            board[index] = symbol;       // Place the symbol in the cell
            return true;                 // Move was successful
        }
        return false;                    // Cell was already taken
    }

    // Asks the AI player to choose a move based on the current board
    public int getAIMove() {
        return player.getAIMove(board);  // Delegates the logic to the AI strategy
    }

    // Checks whether the specified symbol (e.g., "X" or "O") has won the game
    public boolean checkWinner(String symbol) {
        // All possible winning combinations
        int[][] winCombos = {
                {0,1,2}, {3,4,5}, {6,7,8}, // rows
                {0,3,6}, {1,4,7}, {2,5,8}, // columns
                {0,4,8}, {2,4,6}           // diagonals
        };

        // Check each combination to see if all positions contain the same symbol
        for (int[] combo : winCombos) {
            if (symbol.equals(board[combo[0]]) &&
                    symbol.equals(board[combo[1]]) &&
                    symbol.equals(board[combo[2]])) {
                return true;  // Winning combination found
            }
        }

        return false;  // No winning combination found
    }

    // Checks if the board is full (i.e., no empty cells left)
    public boolean isBoardFull() {
        for (String cell : board) {
            if (cell.equals("")) return false;  // Found an empty cell
        }
        return true;  // All cells are filled
    }

    // Resets the board to its initial empty state
    public void reset() {
        Arrays.fill(board, "");  // Clear all cells
    }

    // Returns the current state of the board (used by the view/controller)
    public String[] getBoard() {
        return board;
    }
}
