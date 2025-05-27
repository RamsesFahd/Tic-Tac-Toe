package src.model;

// This is an interface that defines a contract for AI move strategies.
// Any class that implements this interface must provide its own logic for choosing a move.
public interface AIStrategy {

    // Method to be implemented by different AI difficulty strategies (Easy, Medium, Hard)
    // Takes the current game board as input and returns the index of the AI's chosen move
    int chooseMove(String[] board);
}
