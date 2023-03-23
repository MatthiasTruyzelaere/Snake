package view.home;

import view.controls.ControlsPresenter;
import view.controls.Controlsview;
import view.name.NameView;
import view.name.NamePresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HomePresenter {
    private HomeView view;

    // constructor
    public HomePresenter(HomeView view) {
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    // methoden
    private void addEventHandlers() {
        view.getBtnPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NameView nameView = new NameView();

                new NamePresenter(nameView);

                view.getScene().setRoot(nameView);
                nameView.getScene().getWindow().setWidth(500);
                nameView.getScene().getWindow().setHeight(350);
            }
        });

        view.getBtnControls().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Controlsview controlsview = new Controlsview();

                new ControlsPresenter(controlsview);

                view.getScene().setRoot(controlsview);
                controlsview.getScene().getWindow().setWidth(500);
                controlsview.getScene().getWindow().setHeight(450);
            }
        });

        view.getBtnExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(1);
            }
        });
    }
    private void updateView() {
        // Vult de view met data uit model
    }
}