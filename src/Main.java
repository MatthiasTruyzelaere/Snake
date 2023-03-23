import view.home.HomeView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.home.HomePresenter;
import javafx.application.Application;

import java.io.File;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HomeView view = new HomeView();

        new HomePresenter(view);

        Scene scene = new Scene(view);
        scene.getStylesheets().add("/style/main.css");

        stage.setScene(scene);

        // initialisatie stage
        stage.show();
        stage.setWidth(500);
        stage.setHeight(400);
        stage.setResizable(false);
        stage.setTitle("Snake Game");
    }

    public static void main(String[] args) {
        launch(args);
    }
}