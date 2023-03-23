package model;

public class Player {
    private int highScore;
    private String playerName;

    // constructor
    public Player() {
    }

    // getters
    public int getHighScore() {
        return highScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    // setters
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}