package view;

import java.util.List;
import model.SnakeModel;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;

public class SnakeView extends BorderPane {
    private Label lblName;
    private Label lblScore;
    private Label lblHighScore;
    private Rectangle[][] cells;

    // constructor
    public SnakeView(int width, int height, int cellSize) {
        this.initialiseNodes();
        this.layoutNodes(width, height, cellSize);
    }

    // getters
    public Label getLblName() {
        return lblName;
    }

    public Label getLblScore() {
        return lblScore;
    }

    public Label getLblHighScore() {
        return lblHighScore;
    }

    // methoden
    private void initialiseNodes() {
        lblName = new Label();
        lblName.setId("label-2");

        lblScore = new Label();
        lblScore.setId("label-2");

        lblHighScore = new Label();
        lblHighScore.setId("label-2");
    }

    private void layoutNodes(int width, int height, int cellSize) {
        setPrefSize(width * cellSize, height * cellSize);

        // center
        GridPane gridPane = new GridPane();

        this.cells = new Rectangle[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Rectangle cell = new Rectangle(cellSize, cellSize);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.WHITE);
                cell.setX(x * cellSize);
                cell.setY(y * cellSize);
                cells[x][y] = cell;
                gridPane.add(cell, x, y);
            }
        }
        setCenter(gridPane);

        // right
        VBox vBox = new VBox();
        vBox.getChildren().add(lblName);
        vBox.getChildren().add(lblScore);
        vBox.getChildren().add(lblHighScore);

        vBox.setSpacing(25);
        vBox.setPadding(new Insets(25));

        setRight(vBox);
    }

    public void update(SnakeModel model) {
        List<Point2D> snake = model.getSnake();
        Point2D food = model.getFood();
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (snake.contains(new Point2D(x, y))) {
                    cells[x][y].setFill(Color.GREEN);
                } else if (food.equals(new Point2D(x, y))) {
                    cells[x][y].setFill(Color.RED);
                } else {
                    cells[x][y].setFill(Color.WHITE);
                }
            }
        }
    }
}