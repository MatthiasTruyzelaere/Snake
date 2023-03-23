package view.name;

import view.SnakeView;
import model.SnakeModel;
import view.SnakePresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class NamePresenter {
    private NameView view;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final int CELL_SIZE = 20;

    // constructor
    public NamePresenter(NameView view) {
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    // methoden
    private void addEventHandlers() {
        view.getBtnSubmit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!view.getTxtName().getText().isEmpty()) {
                    SnakeModel snakeModel = new SnakeModel(WIDTH, HEIGHT);
                    SnakeView snakeView = new SnakeView(WIDTH, HEIGHT, CELL_SIZE);
                    snakeModel.getPlayer().setPlayerName(view.getTxtName().getText());

                    new SnakePresenter(snakeView, snakeModel);
                    view.getScene().setRoot(snakeView);

                    snakeView.requestFocus();
                    snakeView.getScene().getWindow().sizeToScene();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Name Field Empty");
                    alert.setContentText("Please provide a username");
                    alert.showAndWait();
                }
            }
        });

        view.getTxtName().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER && !view.getTxtName().getText().isEmpty()) {
                    view.getBtnSubmit().fire();
                }
            }
        });
    }
    private void updateView() {
        // Vult de view met data uit model
    }
}