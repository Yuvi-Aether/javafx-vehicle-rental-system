package application;

class Car {

    String id;
    String model;
    int pricePerDay;
    String status;
    String currentRenter;

    Car(String m, String p, String s, String i,String r) {
        this.model = m;
        this.pricePerDay = Integer.parseInt(p);
        this.id = i;
        this.currentRenter = r;
        this.status = s;
    }
}
