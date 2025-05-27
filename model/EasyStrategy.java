package src.model;

import java.util.*;

// This class implements the AIStrategy interface to provide a simple (easy) AI behavior.
// The easy strategy chooses a random available spot on the board.
public class EasyStrategy implements AIStrategy {

    // This method selects a move randomly from the empty cells on the board.
    @Override
    public int chooseMove(String[] board) {
        List<Integer> available = new ArrayList<>(); // List to store indexes of empty cells

        // Loop through the board to find empty spots
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals("")) {
                available.add(i); // Add index to the list if cell is empty
            }
        }

        // If there are no empty cells, return -1 (no move possible)
        if (available.isEmpty()) return -1;

        // Shuffle the list to randomize move selection
        Collections.shuffle(available);

        // Return the first randomly selected move
        return available.get(0);
    }
}
