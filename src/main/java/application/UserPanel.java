package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserPanel extends control {

    @FXML
    Label uLable;

    public void initialize() {
        String user = Session.currentUser.name;
        uLable.setText("Welcome, " + user);
    }

    public void logout(ActionEvent e) {
        super.logout(e);
    }
}
