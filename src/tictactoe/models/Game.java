package tictactoe.models;

import tictactoe.exceptions.BotCountMOreThanOneException;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.PlayerCountException;
import tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private Player winner;
    private int nextPlayerIndex;
    private GameState gameState;
    private int dimension;

    private Game(int dimension, List<Player> players, List<WinningStrategy>winningStrategies){
        this.dimension = dimension;
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public static class Builder{
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimensions(int dimension) {
            this.dimension = dimension;
            return this;
        }

        private void validateBotCount() throws BotCountMOreThanOneException {
            int botSize=0;
            for(Player player: players){
                if(player.getPlayerType().equals(PlayerType.BOT))
                    botSize += 1;
            }

            if(botSize > 1){
                throw new BotCountMOreThanOneException();
            }
        }

        private void validateDimensionsAndPlayerCount() throws PlayerCountException {
            if(players.size() != this.dimension -1)
                throw new PlayerCountException();
        }

        // Size should not be zero

        private void validateSymbolUniqueness() throws DuplicateSymbolException {
            Map<Character, Integer> symbolCount = new HashMap<>();
            for(Player player: players){
                if(!symbolCount.containsKey(player.getSymbol().getaChar())){
                    symbolCount.put(player.getSymbol().getaChar(), 0);
                }
                symbolCount.put(
                        player.getSymbol().getaChar(),
                        symbolCount.get(player.getSymbol().getaChar()) +1
                );

                if(symbolCount.get(player.getSymbol().getaChar()) >1) {
                    throw new DuplicateSymbolException();
                }
            }

            //Above logic can be replaced with Set as well.
        }

        private void validate() throws BotCountMOreThanOneException, DuplicateSymbolException, PlayerCountException {
            validateBotCount();
            validateSymbolUniqueness();
            validateDimensionsAndPlayerCount();
        }

        public Game build() throws PlayerCountException, DuplicateSymbolException, BotCountMOreThanOneException {
            validate();
            return null;
        }
    }
}
