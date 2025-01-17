package tictactoe;

import tictactoe.controller.GameController;
import tictactoe.exceptions.BotCountMOreThanOneException;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.PlayerCountException;
import tictactoe.models.*;
import tictactoe.strategies.winningStrategies.ColWinningStrategy;
import tictactoe.strategies.winningStrategies.DiagonalWinningStrategy;
import tictactoe.strategies.winningStrategies.RowWinningStrategy;
import tictactoe.strategies.winningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // For interview, you may need to take input.
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int dimensions = 3;
        List<Player> players = new ArrayList<>();
        players.add(
             new Player(1L, "Rishabh", new Symbol('X'), PlayerType.HUMAN)
        );
        players.add(
                new Bot(2L, "GPT", new Symbol('O'), BotDifficultyLevel.EASY)
        );

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        try {
            Game game = gameController.startGame(
                    dimensions,
                    players,
                    winningStrategies
            );
            while(gameController.checkGameState(game).equals(GameState.IN_PROGRESS)){
                gameController.printBoard(game);

                gameController.makeMove(game);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
