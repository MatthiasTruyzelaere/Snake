package view.home;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class HomeView extends BorderPane {
    private Button btnPlay;
    private Button btnExit;
    private Button btnControls;
    private Label lblSceneTitle;

    // constructor
    public HomeView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // getters
    public Button getBtnPlay() {
        return btnPlay;
    }

    public Button getBtnExit() {
        return btnExit;
    }

    public Button getBtnControls() {
        return btnControls;
    }

    // methoden
    private void initialiseNodes() {
        btnPlay = new Button("Play");
        btnPlay.setId("button");

        btnExit = new Button("Exit");
        btnExit.setId("button");

        btnControls = new Button("Controls");
        btnControls.setId("button");

        lblSceneTitle = new Label("SNAKE");
        lblSceneTitle.setId("label-1");
    }

    private void layoutNodes() {
        // top
        setTop(lblSceneTitle);
        setAlignment(lblSceneTitle, Pos.CENTER);
        setMargin(lblSceneTitle, new Insets(50, 0, 0, 0));

        // center
        VBox vBox = new VBox();

        vBox.getChildren().add(btnPlay);
        vBox.getChildren().add(btnControls);
        vBox.getChildren().add(btnExit);

        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);

        setCenter(vBox);
    }
}