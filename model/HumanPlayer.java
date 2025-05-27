package src.model;

// This class represents a human player.
// It implements the Player interface but does not make AI decisions.
public class HumanPlayer implements Player {

    // Since human moves are controlled by the user (via the UI),
    // this method always returns -1 to indicate that the AI should not make a move.
    @Override
    public int getAIMove(String[] board) {
        return -1; // No move to make — human chooses manually through the GUI
    }
}
