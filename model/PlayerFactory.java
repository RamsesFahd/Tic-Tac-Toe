package src.model;

// This class is responsible for creating different types of players (AI or human) based on the game mode.
public class PlayerFactory {

    // Static method to create a player based on the given mode
    public static Player createPlayer(String mode) {
        // Switch based on the mode and return the corresponding player
        switch (mode) {
            case "easy":
                // Create an AI player with the EasyStrategy
                return new AIPlayer(new EasyStrategy());

            case "medium":
                // Create an AI player with the MediumStrategy
                return new AIPlayer(new MediumStrategy());

            case "hard":
                // Create an AI player with the HardStrategy
                return new AIPlayer(new HardStrategy());

            default:
                // If no valid mode is provided, return a HumanPlayer (default mode)
                return new HumanPlayer();
        }
    }
}
