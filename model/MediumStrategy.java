package src.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class represents a medium-difficulty AI strategy.
// It tries to take the center if available, otherwise chooses a random move.
public class MediumStrategy implements AIStrategy {

    // Main method to choose the AI's move
    @Override
    public int chooseMove(String[] board) {
        List<Integer> available = new ArrayList<>();  // List of empty cell indices

        // Collect all available (empty) positions on the board
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals("")) {
                available.add(i);
            }
        }

        // If no moves are available, return -1
        if (available.isEmpty()) return -1;

        // Try to take the center of the board if available (best general position)
        int center = board.length / 2; // For a 3x3 board, this will be index 4
        if (available.contains(center)) {
            return center; // Prioritize the center
        }

        // If center is not available, choose a random available move
        Collections.shuffle(available); // Shuffle the list to randomize selection
        return available.get(0);        // Return the first random move
    }
}
