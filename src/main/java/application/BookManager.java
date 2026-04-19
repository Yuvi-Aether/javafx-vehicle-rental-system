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
    Label bLabel;
    @FXML
    Label rLabel;
    @FXML
    DatePicker StDate;
    @FXML
    DatePicker EndDate;
    @FXML
    Button rButton;
    @FXML
    Button LButton;

    Vehicles vehicles = Session.vehicles;

    public void initialize() {
        bLabel.setWrapText(true);
        bLabel.setMaxWidth(Double.MAX_VALUE);
        bLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");
        bLabel.setText("Vehicle Id: " + Booking.vehicleId
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

        rLabel.setWrapText(true);
        rLabel.setMaxWidth(Double.MAX_VALUE);
        rLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white; -fx-font-weight: bold;");

    }

    public void Hello(ActionEvent e) {
        Booking.startDate = StDate.getValue();
        Booking.endDate = EndDate.getValue();
        long days = java.time.temporal.ChronoUnit.DAYS.between(Booking.startDate, Booking.endDate);
        Booking.totalPrice = (int) (days * Booking.priceperday);

        vehicles.RentItem(Booking.vehicleId);

        System.err.println("Booking Confirmed for " + Booking.VehicleName);
        System.err.println("Total Price: " + Booking.totalPrice);

        rButton.setDisable(true);
        rLabel.setOpacity(1);
        rLabel.setText(Booking.username
                + "\n Vehicle: " + Booking.VehicleName
                + "\n From - " + Booking.startDate
                + "\n To - " + Booking.endDate
                + "\n Total Rent: " + Booking.totalPrice + "₹");
        LButton.setOpacity(1);
    }
    public void Gallary(ActionEvent e){
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

}
