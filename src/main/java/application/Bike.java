package application;

public class Bike {
     String id;
    String model;
    int pricePerDay;
    String status;

    Bike(String m, String p, String s, String i) {
        this.model = m;
        this.pricePerDay = Integer.parseInt(p);
        this.id = i;
        this.status = s;
    }
}
