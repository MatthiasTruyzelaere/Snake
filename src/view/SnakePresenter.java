package view;

import model.SnakeModel;
import java.util.Optional;
import javafx.util.Duration;
import javafx.geometry.Point2D;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;

public class SnakePresenter {
    private SnakeView view;
    private SnakeModel model;
    private Timeline timeline;
    private Point2D direction;

    // constructor
    public SnakePresenter(SnakeView view, SnakeModel model) {
        this.view = view;
        this.model = model;
        this.direction = new Point2D(1, 0);

        this.addEventHandlers();
        this.updateView();

        view.getLblName().setText("Go " + model.getPlayer().getPlayerName());
        view.getLblScore().setText("Score: " + model.getGame().getScore());
        view.getLblHighScore().setText("Hi-Score: " + model.readHighscore());

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), event -> {
            model.updateSnake(direction);
            view.update(model);
            view.getLblScore().setText("Score: " + model.getGame().getScore());
            if (model.isGameOver()) {
                timeline.stop();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "");
                alert.setTitle("Game Over");
                alert.setHeaderText("You scored " + model.getGame().getScore() + " point(s)");
                alert.show();

                alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
                    @Override
                    public void handle(DialogEvent event) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK, ButtonType.NO);
                        alert.setTitle("Try Again?");
                        alert.setHeaderText("Do you want to play again?");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            SnakeModel snakeModel = new SnakeModel(20, 20);
                            SnakeView snakeView = new SnakeView(20, 20, 20);

                            snakeModel.getPlayer().setPlayerName(model.getPlayer().getPlayerName());
                            snakeModel.getPlayer().setHighScore(model.getPlayer().getHighScore());

                            new SnakePresenter(snakeView, snakeModel);
                            view.getScene().setRoot(snakeView);

                            snakeView.requestFocus();
                            snakeView.getScene().getWindow().sizeToScene();
                        } else if (result.get() == ButtonType.NO) {
                            System.exit(1);
                        }
                    }
                });
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // methoden
    private void addEventHandlers() {
        this.view.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case Z, W, UP:
                        if (!direction.equals(new Point2D(0, 1))) {
                            direction = new Point2D(0, -1);
                        }
                        break;

                    case S, DOWN:
                        if (!direction.equals(new Point2D(0, -1))) {
                            direction = new Point2D(0, 1);
                        }
                        break;

                    case Q, A, LEFT:
                        if (!direction.equals(new Point2D(1, 0))) {
                            direction = new Point2D(-1, 0);
                        }
                        break;

                    case D, RIGHT:
                        if (!direction.equals(new Point2D(-1, 0))) {
                            direction = new Point2D(1, 0);
                        }
                        break;

                    case ESCAPE:
                        timeline.pause();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.YES);
                        alert.setTitle("Pause");
                        alert.setHeaderText("Click YES to continue");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.YES) {
                            timeline.play();
                        }
                        break;
                }
            }
        });
    }

    private void updateView() {
        // Vult de view met data uit model
    }
}