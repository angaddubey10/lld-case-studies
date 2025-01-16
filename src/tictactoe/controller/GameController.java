package tictactoe.controller;

import tictactoe.exceptions.BotCountMOreThanOneException;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.PlayerCountException;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    //Stateful - Game is a global state here.
//    Game game;
//    public Game startGame(){
//        game = new Game();
//        return game;
//    }

    public  Game startGame(int dimensions, List<Player> players, List<WinningStrategy> winningStrategies) throws PlayerCountException, DuplicateSymbolException, BotCountMOreThanOneException {
        return Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }
}
