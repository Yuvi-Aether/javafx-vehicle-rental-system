package application;

class Booking{
    String username;
    String vehicleId;
    String startDate;
    String endDate;
    int    totalPrice;
    String status;

    Booking(String u, String v, String s, String e, int p, String st){
        this.username = u;
        this.vehicleId = v;
        this.startDate = s;
        this.endDate = e;
        this.totalPrice = p;
        this.status = st;
    }
}