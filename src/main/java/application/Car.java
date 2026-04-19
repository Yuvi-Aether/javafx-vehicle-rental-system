package application;

class Car {

    String id;
    String model;
    int pricePerDay;
    String status;

    Car(String m, String p, String s, String i) {
        this.model = m;
        this.pricePerDay = Integer.parseInt(p);
        this.id = i;
        this.status = s;
    }
}
