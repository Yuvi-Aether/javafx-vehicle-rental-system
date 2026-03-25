package application;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent Root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        Scene scene = new Scene(Root);
        String css = this.getClass().getResource("/application.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setTitle("Vehicle rental System");
        stage.getIcons().add(
                new Image(getClass().getResource("/captain-puffy.jpg").toExternalForm())
        );

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();

    }
}
