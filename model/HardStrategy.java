package src.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class implements a hard difficulty strategy for the AI.
// The AI tries to win if possible, block the opponent if needed, or pick randomly otherwise.
public class HardStrategy implements AIStrategy {

    // Main method to choose the best move for the AI
    @Override
    public int chooseMove(String[] board) {
        String player = "X";     // The AI plays as "X"
        String opponent = "O";   // The human (or other player) is "O"

        // 1. First, try to win: check each empty spot to see if placing "X" would result in a win
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals("")) {
                board[i] = player;                // Try the move
                if (isWinning(board, player)) {   // Check if it wins
                    board[i] = "";                // Undo the move
                    return i;                     // Return winning move
                }
                board[i] = ""; // Reset the cell
            }
        }

        // 2. If no winning move, try to block the opponent from winning
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals("")) {
                board[i] = opponent;                // Simulate opponent move
                if (isWinning(board, opponent)) {   // Check if they could win
                    board[i] = "";                  // Undo the move
                    return i;                       // Block the opponent
                }
                board[i] = ""; // Reset the cell
            }
        }

        // 3. If no immediate win or block, pick a random move from the available cells
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals("")) {
                available.add(i);
            }
        }

        // If board is full, return -1 (no valid move)
        if (available.isEmpty()) return -1;

        // Shuffle and return a random available move
        Collections.shuffle(available);
        return available.get(0);
    }

    // Helper method to check if a specific symbol (X or O) has a winning combination on the board
    private boolean isWinning(String[] board, String symbol) {
        int[][] winPatterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6}            // Diagonals
        };

        for (int[] pattern : winPatterns) {
            if (board[pattern[0]].equals(symbol) &&
                    board[pattern[1]].equals(symbol) &&
                    board[pattern[2]].equals(symbol)) {
                return true; // Found a winning pattern
            }
        }

        return false; // No winning pattern found
    }
}
