package application;

class Vehicles{
    String id;
    String name;
    String type;
    String model;
    String pricePerDay;
    String year;
    String status;

    Vehicles(String n,String m,String p,String y,String t,String s,String i){
        this.name = n;
        this.model = m;
        this.pricePerDay = p;
        this.year = y;
        this.type = t;
        this.id = i;
        this.status = s;
    }
}