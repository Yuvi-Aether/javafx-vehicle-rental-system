package application;

import java.util.ArrayList;

class Vehicles implements Rental {

    ArrayList<Truck> trucks = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Bike> Bikes = new ArrayList<>();

    public Vehicles() {
        // Trucks
        trucks.add(new Truck("Eicher Pro 1100", "2500", "Available", "T001", null));
        trucks.add(new Truck("Tata Ace", "2000", "Available", "T002", null));
        trucks.add(new Truck("Ashok Leyland", "3000", "Booked", "T003", null));
        trucks.add(new Truck("Eicher Pro 1100", "2500", "Available", "T004", null));
        trucks.add(new Truck("Tata Ace", "2000", "Available", "T005", null));
        trucks.add(new Truck("Ashok Leyland", "3000", "Available", "T006", null));
        trucks.add(new Truck("Eicher Pro 1100", "2500", "Available", "T007", null));
        trucks.add(new Truck("Tata Ace", "2000", "Available", "T008", null));

        // Cars
        cars.add(new Car("Hyundai i20", "1800", "Available", "C001", null));
        cars.add(new Car("Honda City", "2200", "Available", "C002", null));
        cars.add(new Car("Maruti Swift", "1500", "Booked", "C003", null));
        cars.add(new Car("Toyota Fortuner", "4500", "Available", "C004", null));
        cars.add(new Car("Mahindra XUV", "3000", "Available", "C005", null));
        cars.add(new Car("Hyundai i20", "1800", "Available", "C006", null));
        cars.add(new Car("Honda City", "2200", "Available", "C007", null));
        cars.add(new Car("Maruti Swift", "1500", "Available", "C008", null));
        cars.add(new Car("Toyota Fortuner", "4500", "Available", "C009", null));
        cars.add(new Car("Mahindra XUV", "3000", "Available", "C010", null));
        cars.add(new Car("Hyundai i20", "1800", "Available", "C011", null));
        cars.add(new Car("Honda City", "2200", "Available", "C012", null));

        // Bikes
        Bikes.add(new Bike("Yamaha FZ", "700", "Available", "B001", null));
        Bikes.add(new Bike("Hero MotoCorp", "600", "Available", "B002", null));
        Bikes.add(new Bike("Bajaj Pulsar", "650", "Booked", "B003", null));
        Bikes.add(new Bike("Honda CB Shine", "750", "Available", "B004", null));
        Bikes.add(new Bike("Yamaha FZ", "700", "Available", "B005", null));
        Bikes.add(new Bike("Hero MotoCorp", "600", "Available", "B006", null));
        Bikes.add(new Bike("Bajaj Pulsar", "650", "Available", "B007", null));
        Bikes.add(new Bike("Honda CB Shine", "750", "Available", "B008", null));
        Bikes.add(new Bike("Yamaha FZ", "700", "Available", "B009", null));
        Bikes.add(new Bike("Hero MotoCorp", "600", "Available", "B010", null));
    }

    @Override
    public String CheckAvailability(String status) {
        if (status.equals("Available")) {
            System.out.println("Item is available for rent.");
            return "Available";
        } else {
            System.out.println("Item is currently booked.");
            return "Booked";
        }
    }

    @Override
    public void RentItem(String id) {
        for (Truck truck : trucks) {
            if (truck.id.equals(id)) {
                if (truck.status.equals("Booked")) {
                    System.out.println("Sorry, this item is currently booked.");
                    return;
                }
                truck.status = "Booked";
                truck.currentRenter = Booking.username;

                return;
            }
        }
        for (Car car : cars) {
            if (car.id.equals(id)) {
                if (car.status.equals("Booked")) {
                    System.out.println("Sorry, this item is currently booked.");
                    return;
                }
                car.status = "Booked";
                car.currentRenter = Booking.username;
                return;
            }
        }
        for (Bike bike : Bikes) {
            if (bike.id.equals(id)) {
                if (bike.status.equals("Booked")) {
                    System.out.println("Sorry, this item is currently booked.");
                    return;
                }
                bike.status = "Booked";
                bike.currentRenter = Booking.username;
                return;
            }
        }

    }

    public void ReturnItem(String id) {
        for (Truck truck : trucks) {
            if (truck.id.equals(id)) {
                truck.status = "Available";
                truck.currentRenter = null;
                return;
            }
        }

        for (Car car : cars) {
            if (car.id.equals(id)) {
                car.status = "Available";
                car.currentRenter = null;
                return;
            }
        }

        for (Bike bike : Bikes) {
            if (bike.id.equals(id)) {
                bike.status = "Available";
                bike.currentRenter = null;
                return;
            }
        }
    }

}
