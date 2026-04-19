package application;

import java.util.ArrayList;

class LoginControl {

    ArrayList<Users> users = new ArrayList<>();

    public LoginControl() {
        users.add(new Users("admin", "123", "admin", "Admin User"));
        users.add(new Users("user", "123", "user", "Regular User"));
    }

    public Users Login(String username, String password) {
        for (Users u : users) {
            if (u.username.equals(username) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }
}
