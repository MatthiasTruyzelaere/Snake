package model;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;

public class SnakeModel {
    private Game game;
    private int width;
    private int height;
    private Point2D food;
    private Player player;
    private boolean gameOver;
    private List<Point2D> snake;

    // constructor

    /**
     * Maakt een consturctor 'SnakeModel' aan
     * @param width
     * @param height
     */
    public SnakeModel(int width, int height) {
        game = new Game();
        player = new Player();

        this.width = width;
        this.height = height;
        this.gameOver = false;
        this.snake = new ArrayList<>();
        this.snake.add(new Point2D(width/2, height/2));
        this.food = generateFood();
    }

    // getters
    public Game getGame() {
        return game;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Point2D getFood() {
        return food;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public List<Point2D> getSnake() {
        return snake;
    }

    // methoden

    /**
     * Deze methode gaat een controle uitvoeren op de snake of deze niet een muur, lichaam of food heeft geraakt
     * Deze methode word ook in de timeline (presenter) aangesproken om deze elke x seconden uit te voeren
     * @param direction
     */
    public void updateSnake(Point2D direction) {
        Point2D head = snake.get(0).add(direction);
        if (head.getX() < 0 || head.getX() >= width || head.getY() < 0 || head.getY() >= height) {
            gameOver = true;
            if (game.getScore() > player.getHighScore()) {
                player.setHighScore(game.getScore());
                saveHighscore();
            }
        } else if (snake.contains(head)) {
            gameOver = true;
            if (game.getScore() > player.getHighScore()) {
                player.setHighScore(game.getScore());
                saveHighscore();
            }
        } else {
            snake.add(0, head);
            if (head.equals(food)) {
                food = generateFood();
                game.setScore(game.getScore() + 1);
            } else {
                snake.remove(snake.size()-1);
            }
        }
    }

    /**
     * Deze methode gaat 2 random punten genereren, 1 voor X en Y waarna deze ook in een nieuwe Point2D worden gestopt
     * @return
     */
    private Point2D generateFood() {
        Random random = new Random();
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        Point2D food = new Point2D(x, y);
        if (snake.contains(food)) {
            return generateFood();
        } else {
            return food;
        }
    }

    /**
     * Deze methode gaat nadat het spel gedaan is de highscore van de speler pakken en deze wegschrijven in 'highscore.txt' zodat deze later kan worden opgeroepen in readHighscore()
     */
    public void saveHighscore() {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("highscore.txt", false)))) {
            printWriter.format(player.getHighScore() + "");
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Er is een probleem opgetreden bij het opslaan van de highscore");
        }
    }

    /**
     * Deze methode gaat de file 'highscore.txt' inlezen en de eerste lijn in de String regel stoppen zodat deze kan worden gebruikt om de Label Hi-Score in de presenter in te vullen
     * @return geeft als return een string (highscore van de speler)
     */
    public String readHighscore() {
        String regel = "";
        try {
            BufferedReader inputstream = new BufferedReader(new FileReader("highscore.txt"));
            regel = inputstream.readLine();
            inputstream.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Er is een probleem opgetreden bij het lezen van de highscore");
        }
        return regel;
    }
}