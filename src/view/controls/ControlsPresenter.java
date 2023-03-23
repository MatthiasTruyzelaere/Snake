package view.controls;

import view.home.HomeView;
import view.home.HomePresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControlsPresenter {
    private Controlsview view;

    // constructor
    public ControlsPresenter(Controlsview view) {
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    // methoden
    private void addEventHandlers() {
        view.getBtnGoBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HomeView homeView = new HomeView();

                new HomePresenter(homeView);

                view.getScene().setRoot(homeView);
                homeView.getScene().getWindow().setWidth(500);
                homeView.getScene().getWindow().setHeight(400);
            }
        });
    }
    private void updateView() {
        // Vult de view met data uit model
    }
}
