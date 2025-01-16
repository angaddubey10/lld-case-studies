package tictactoe;

import tictactoe.controller.GameController;
import tictactoe.models.Game;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        Game game = gameController.startGame();

    }
}
