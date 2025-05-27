package src.model;

// This interface defines the contract for any type of player (Human or AI).
// Any class implementing this interface must define how the player makes a move.
public interface Player {

    // Method to determine the player's move.
    // For AI, this will choose a move based on the strategy.
    // For human, this method can be ignored as the move is chosen manually via the UI.
    int getAIMove(String[] board);
}
