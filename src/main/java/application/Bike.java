package application;

public class Bike {

    String id;
    String model;
    int pricePerDay;
    String status;
    String currentRenter;

    Bike(String m, String p, String s, String i,String r) {
        this.model = m;
        this.pricePerDay = Integer.parseInt(p);
        this.id = i;
        this.status = s;
        this.currentRenter = r;
    }
}
