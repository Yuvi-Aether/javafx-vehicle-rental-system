package application;

import java.io.IOException;
import java.net.URL;

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
    Label myLabel;

    public Parent loadFXML(String fxmlFile) throws RuntimeException,IOException {
        URL resource = getClass().getResource(fxmlFile);
        if (resource == null) {
            throw new RuntimeException("FXML file not found: " + fxmlFile);
        }
        return FXMLLoader.load(resource);
    }

    public void switchScene(ActionEvent e, String FXMLFile, String title, String css) {
        try{
        Root = loadFXML(FXMLFile);
        }catch(IOException i){
            System.err.println("File not found");
        }catch(RuntimeException r){
            System.err.println("Root must be not null");
        }catch(Exception d){
            System.err.println("Error!!");
        }
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(Root);

        if (css != null) {
            URL cssFile = getClass().getResource(css);

            if (cssFile == null) {
                throw new RuntimeException("File not found: " + css);
            }

            scene.getStylesheets().add(cssFile.toExternalForm());
        }

        stage.setScene(scene);
        stage.setTitle(title);

        stage.getIcons().add(
                new Image(getClass().getResource("/captain-puffy.jpg").toExternalForm())
        );

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }

    public void login(ActionEvent e) throws Exception {
        String user = Username.getText();
        String pass = Password.getText();

        LoginControl log = new LoginControl();
        String Role = log.Login(user, pass);
        if (Role.equals("Invalid Credentials")) {myLabel.setText(Role);return;}

        if ("admin".equals(Role)) {

            switchScene(e, "/Admin.fxml", "Admin Panel", "/application.css");
        } else {

            switchScene(e, "/User.fxml", "User Panel", "/application.css");
        }
    }

    public void Next(ActionEvent e) throws Exception {

        switchScene(e, "/Access.fxml", "Login Access", "/application.css");
    }

    public void logout(ActionEvent e) {
        Root = vBox.getParent();
        stage = (Stage) vBox.getScene().getWindow();
        switchScene(e, "/Access.fxml", "Login Access", "/application.css");

    }
}
