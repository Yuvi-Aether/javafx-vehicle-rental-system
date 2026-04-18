package application;

class Car {
    int id;
    String model;
    int pricePerDay;
    String status;

    Car(String m, String p, String s, String i) {
        this.model = m;
        this.pricePerDay = Integer.parseInt(p);
        this.id = Integer.parseInt(i);
        this.status = s;
    }
}