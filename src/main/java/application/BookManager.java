package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BookManager {

    @FXML
    Label TitleLabel;
    @FXML
    Label BookLabel;
    @FXML
    DatePicker StDate;
    @FXML
    DatePicker EndDate;
    @FXML
    Button BookButton;
    @FXML
    Button GalleryButton;

    Vehicles vehicles = Session.vehicles;

    public void initialize() {
        TitleLabel.setWrapText(true);
        TitleLabel.setMaxWidth(Double.MAX_VALUE);
        TitleLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");
        TitleLabel.setText("Vehicle Id: " + Booking.vehicleId
                + "\nVehicle Model: " + Booking.VehicleName
                + "\nPrice per Day: " + Booking.priceperday);
        StDate.setValue(java.time.LocalDate.now());
        StDate.dayCellFactoryProperty().setValue(param -> new javafx.scene.control.DateCell() {
            @Override
            public void updateItem(java.time.LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setDisable(empty || item.isBefore(java.time.LocalDate.now()));
            }
        });
        EndDate.setValue(java.time.LocalDate.now().plusDays(1));
        EndDate.dayCellFactoryProperty().setValue(param -> new javafx.scene.control.DateCell() {
            @Override
            public void updateItem(java.time.LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setDisable(empty || item.isBefore(StDate.getValue().plusDays(1)));
            }
        });

        BookLabel.setWrapText(true);
        BookLabel.setMaxWidth(Double.MAX_VALUE);
        BookLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold;");

    }

    public void Hello(ActionEvent e) {
        Booking.startDate = StDate.getValue();
        Booking.endDate = EndDate.getValue();
        long days = java.time.temporal.ChronoUnit.DAYS.between(Booking.startDate, Booking.endDate);
        Booking.totalPrice = (int) (days * Booking.priceperday);

        vehicles.RentItem(Booking.vehicleId);

        System.err.println("Booking Confirmed for " + Booking.VehicleName);
        System.err.println("Total Price: " + Booking.totalPrice);

        BookButton.setDisable(true);
        BookLabel.setOpacity(1);
        BookLabel.setText(Booking.username
                + "\n Vehicle: " + Booking.VehicleName
                + "\n From - " + Booking.startDate
                + "\n To - " + Booking.endDate
                + "\n Total Rent: " + Booking.totalPrice + "₹");
        GalleryButton.setOpacity(1);
    }

    public void Gallery(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

}
