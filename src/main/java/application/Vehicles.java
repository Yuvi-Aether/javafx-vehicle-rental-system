package application;

import java.util.ArrayList;

class Vehicles implements Rental {
    
    ArrayList<Truck> trucks= new ArrayList<>();
    ArrayList<Car> cars= new ArrayList<>();
    ArrayList<Bike> Bikes= new ArrayList<>();

    public Vehicles(){
        // Trucks
        trucks.add(new Truck("Eicher Pro 1100", "2500", "Available", "T001"));
        trucks.add(new Truck("Tata Ace", "2000", "Available", "T002"));
        trucks.add(new Truck("Ashok Leyland", "3000", "Booked", "T003"));
        
        // Cars
        cars.add(new Car("Hyundai i20", "1800", "Available", "C001"));
        cars.add(new Car("Honda City", "2200", "Available", "C002"));
        cars.add(new Car("Maruti Swift", "1500", "Booked", "C003"));
        cars.add(new Car("Toyota Fortuner", "4500", "Available", "C004"));
        cars.add(new Car("Mahindra XUV", "3000", "Available", "C005"));
        
        // Bikes
        Bikes.add(new Bike("Yamaha FZ", "700", "Available", "B001"));
        Bikes.add(new Bike("Hero MotoCorp", "600", "Available", "B002"));
        Bikes.add(new Bike("Bajaj Pulsar", "650", "Booked", "B003"));
        Bikes.add(new Bike("Honda CB Shine", "750", "Available", "B004"));
    }
    
    @Override
    public void CheckAvailability() {}

    @Override
    public void RentItem() {}

}