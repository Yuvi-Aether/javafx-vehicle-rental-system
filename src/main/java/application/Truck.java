package application;

class Truck{
    int id;
    String model;
    int pricePerDay;
    String status;

    Truck(String m, String p, String s, String i) {
        this.model = m;
        this.pricePerDay = Integer.parseInt(p);
        this.id = Integer.parseInt(i);
        this.status = s;
    }
}