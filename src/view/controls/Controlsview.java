package view.controls;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class Controlsview extends BorderPane {
    private Label lblUp;
    private Label lblDown;
    private Label lblLeft;
    private Label lblRight;
    private Button btnGoBack;
    private Label lblSceneTitle;

    // constructor
    public Controlsview() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // getters
    public Button getBtnGoBack() {
        return btnGoBack;
    }

    // methoden
    private void initialiseNodes() {
        lblUp = new Label("UP : Z, W or ↑");
        lblUp.setId("label-2");

        lblDown = new Label("DOWN : S or ↓");
        lblDown.setId("label-2");

        lblLeft = new Label("LEFT : A, Q or ←");
        lblLeft.setId("label-2");

        lblRight = new Label("RIGHT : D or →");
        lblRight.setId("label-2");

        btnGoBack = new Button("Go Back");
        btnGoBack.setId("button");

        lblSceneTitle = new Label("CONTROLS");
        lblSceneTitle.setId("label-1");
    }

    private void layoutNodes() {
        // top
        setTop(lblSceneTitle);
        setAlignment(lblSceneTitle, Pos.CENTER);
        setMargin(lblSceneTitle, new Insets(50, 0, 0, 0));

        // center
        VBox vBox = new VBox();

        vBox.getChildren().add(lblUp);
        vBox.getChildren().add(lblDown);
        vBox.getChildren().add(lblLeft);
        vBox.getChildren().add(lblRight);

        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);

        setCenter(vBox);

        // bottom
        setBottom(btnGoBack);
        setAlignment(btnGoBack, Pos.CENTER);
        setMargin(btnGoBack, new Insets(0, 0, 20, 0));
    }
}
