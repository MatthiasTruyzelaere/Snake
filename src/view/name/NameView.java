package view.name;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class NameView extends BorderPane {
    private TextArea txtName;
    private Button btnSubmit;
    private Label lblSceneTitle;

    // constructor
    public NameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    // getters
    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public TextArea getTxtName() {
        return txtName;
    }

    // methoden
    private void initialiseNodes() {
        lblSceneTitle = new Label("PLAYER NAME");
        lblSceneTitle.setId("label-1");

        txtName = new TextArea();
        txtName.setId("input");

        btnSubmit = new Button("Submit");
        btnSubmit.setId("button");
    }

    private void layoutNodes() {
        // top
        setTop(lblSceneTitle);
        setAlignment(lblSceneTitle, Pos.CENTER);
        setMargin(lblSceneTitle, new Insets(50, 0, 20, 0));

        // center
        VBox vBox = new VBox();

        vBox.getChildren().add(txtName);
        vBox.getChildren().add(btnSubmit);

        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);

        setCenter(vBox);
    }
}