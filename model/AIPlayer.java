package src.model;

// This class represents an AI-controlled player in the game.
// It uses a strategy object to decide what move to make.
public class AIPlayer implements Player {

    // A reference to the strategy that determines how the AI makes decisions (easy, medium, hard)
    private AIStrategy strategy;

    // Constructor: Initializes the AI player with a specific strategy
    public AIPlayer(AIStrategy strategy) {
        this.strategy = strategy;
    }

    // This method is called to get the move that the AI wants to play
    // It passes the current board state to the strategy and returns the chosen move index
    public int getAIMove(String[] board) {
        return strategy.chooseMove(board);
    }
}
