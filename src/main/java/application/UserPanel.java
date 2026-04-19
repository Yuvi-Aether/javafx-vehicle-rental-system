package application;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UserPanel extends control {

    String Choices[] = {"Car", "Truck", "Bike"};

    @FXML
    Label uLable;

    @FXML
    ChoiceBox<String> Choice;
    @FXML
    TilePane Tile;
    @FXML
    Label cLable;

    Vehicles vehicles = Session.vehicles;

    public void initialize() {
        String user = Session.currentUser.name;
        uLable.setText("Welcome, " + user);
        Choice.getItems().addAll(Choices);

        Choice.setValue(Choices[0]);
        Choice.setOnAction(e -> loadVehicles());
        loadVehicles();
    }

    public void loadVehicles() {
        Tile.getChildren().clear();

        String selected = Choice.getValue();

        if (selected == null) {
            return;
        }

        switch (selected) {

            case "Car" -> {
                for (Car car : vehicles.cars) {
                    VBox card = createCard(
                            car.model,
                            car.pricePerDay,
                            car.status,
                            car.id
                    );
                    Tile.getChildren().add(card);
                }
            }

            case "Truck" -> {
                for (Truck truck : vehicles.trucks) {
                    VBox card = createCard(
                            truck.model,
                            truck.pricePerDay,
                            truck.status,
                            truck.id
                    );
                    Tile.getChildren().add(card);
                }
            }

            case "Bike" -> {
                for (Bike bike : vehicles.Bikes) {
                    VBox card = createCard(
                            bike.model,
                            bike.pricePerDay,
                            bike.status,
                            bike.id
                    );
                    Tile.getChildren().add(card);
                }
            }
        }
    }

    // Common card for all vehicles
    private VBox createCard(String model, int price, String status, String id) {

        Label modelLabel = new Label("Model: " + model);
        Label priceLabel = new Label("Price/Day: ₹" + price);
        Label statusLabel = new Label("Status: " + status);
        Label idLabel = new Label("ID: " + id);

        Button rentBtn = new Button("Rent");
        rentBtn.getStyleClass().add("mclaren-button");

        Button returnBtn = new Button("Return");
        returnBtn.getStyleClass().add("mclaren-button");
        returnBtn.setVisible(false);
        returnBtn.setManaged(false);

        if ("Booked".equals(status)) {
            returnBtn.setVisible(true);
            returnBtn.setManaged(true);
        }

        rentBtn.setOnAction(e -> {
            String availability = vehicles.CheckAvailability(status);
            if (availability.equals("Booked")) {
                cLable.setOpacity(1);
                cLable.setText("Sorry, this item is currently booked.");
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(a -> cLable.setOpacity(0));
                pause.play();
                return; // Do not proceed if the item is booked
            }
            Booking.vehicleId = id;
            Booking.username = Session.currentUser.name;
            Booking.priceperday = price;
            Booking.VehicleName = model;
            Booking.status = availability;
            openBookingWindow((Stage) ((Node) e.getSource()).getScene().getWindow());
        });

        returnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                vehicles.ReturnItem(id);
                cLable.setOpacity(1);
                cLable.setText("Item returned successfully.");
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(a -> cLable.setOpacity(0));
                pause.play();
                loadVehicles();
            }
        });

        VBox card = new VBox(10);
        card.getChildren().addAll(
                modelLabel,
                priceLabel,
                statusLabel,
                idLabel,
                rentBtn,
                returnBtn
        );

        card.getStyleClass().add("tile-card");

        return card;
    }

    private void openBookingWindow(Stage owner) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VehicleGallary.fxml"));
            Parent root = loader.load();

            Stage bookingStage = new Stage();
            bookingStage.initOwner(owner);
            bookingStage.setTitle("Booking Panel");
            Scene bookingScene = new Scene(root);
            bookingStage.setScene(bookingScene);
            bookingStage.setFullScreen(false);
            bookingStage.setResizable(false);

            double bookingWidth = 760;
            double bookingHeight = 460;
            double ownerX = owner.getX();
            double ownerY = owner.getY();
            double ownerWidth = owner.getWidth();

            bookingStage.setWidth(bookingWidth);
            bookingStage.setHeight(bookingHeight);
            bookingStage.setX(ownerX + ownerWidth - bookingWidth - 20);
            bookingStage.setY(ownerY + 80);

            if (bookingStage.getX() < 0) {
                bookingStage.setX(Screen.getPrimary().getVisualBounds().getMaxX() - bookingWidth - 20);
            }

            bookingStage.show();
            String css = this.getClass().getResource("/application.css").toExternalForm();
            bookingScene.getStylesheets().add(css);
            bookingStage.setOnHidden(e -> loadVehicles());
        } catch (IOException ex) {
            System.err.println("Could not open booking window: " + ex.getMessage());
        }
    }

    @Override
    public void logout(ActionEvent e) {
        super.logout(e);
    }
}
