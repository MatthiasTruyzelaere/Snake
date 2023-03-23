package model;

public class Game {
    private int score;

    // constructor
    public Game() {
        setScore(0);
    }

    // getters
    public int getScore() {
        return score;
    }

    // setters
    public void setScore(int score) {
        this.score = score;
    }
}