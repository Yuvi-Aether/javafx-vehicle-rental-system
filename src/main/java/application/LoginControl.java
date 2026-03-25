package application;

import java.util.ArrayList;

class LoginControl{

    ArrayList <duck> users= new ArrayList<>();
    public LoginControl() {
        users.add(new duck("admin", "123", "admin"));
        users.add(new duck("user", "123", "user"));
    }

    public String Login(String username,String password){
            for (duck u : users) {
            if (u.user.equals(username) && u.pass.equals(password)) {
                return "Login Successful: " + u.role;
            }
        }
        return "Invalid Credentials";
    }
}
class duck{
    String user;
    String pass;
    String role;
    duck(String u,String p,String r){
        this.user = u;
        this.pass = p;
        this.role = r;
    }
}