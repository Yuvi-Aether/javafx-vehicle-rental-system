package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class control {

    @FXML
    VBox vBox;

    Parent Root;
    Stage stage;
    Scene scene;

    //access system
    @FXML
    TextField Username;
    @FXML
    PasswordField Password;
    @FXML
    Label myLable;

    public void login(ActionEvent e) throws Exception {
        String user = Username.getText();
        String pass = Password.getText();

        LoginControl l = new LoginControl();
        String s = l.Login(user, pass);
        if (s.equals("Invalid Credentials")) {myLable.setText(s);return;}

        if ("admin".equals(s)) {
            Root = FXMLLoader.load(getClass().getResource("/Admin.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            scene = new Scene(Root);

            stage.setScene(scene);
            stage.setTitle("Admin Panel");
            stage.getIcons().add(
                    new Image(getClass().getResource("/captain-puffy.jpg").toExternalForm())
            );

            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            stage.show();
        } else {
            Root = FXMLLoader.load(getClass().getResource("/User.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            scene = new Scene(Root);

            stage.setScene(scene);
            stage.setTitle("User Panel");
            stage.getIcons().add(
                    new Image(getClass().getResource("/captain-puffy.jpg").toExternalForm())
            );

            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
            stage.show();
        }
    }

    public void Next(ActionEvent e) throws Exception {
        Root = FXMLLoader.load(getClass().getResource("/Access.fxml"));
        String css = this.getClass().getResource("/application.css").toExternalForm();

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        scene = new Scene(Root);
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setTitle("Login Access");
        stage.getIcons().add(
                new Image(getClass().getResource("/captain-puffy.jpg").toExternalForm())
        );

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }

    public void logout(ActionEvent e) {
        Root = vBox.getParent();
        stage = (Stage) vBox.getScene().getWindow();
        stage.close();

    }
}
