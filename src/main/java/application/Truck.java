package application;

class Truck {

    String id;
    String model;
    int pricePerDay;
    String status;
    String currentRenter;

    Truck(String m, String p, String s, String i,String r) {
        this.model = m;
        this.pricePerDay = Integer.parseInt(p);
        this.id = i;
        this.currentRenter = r;
        this.status = s;
    }
}
