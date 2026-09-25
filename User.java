public class User {
    private String[] userData;
    private boolean loggedIn;

    public User(String email, String username, String password) {

        userData = new String[3];

        userData[0] = email;
        userData[1] = username;
        userData[2] = password;

        loggedIn = false;
    }


    // ========================================================
    // LOGIN USING EMAIL AND PASSWORD
    // ========================================================
    public boolean login(String email, String password) {

        if (userData[0].equalsIgnoreCase(email)
                && userData[2].equals(password)) {

            loggedIn = true;

            System.out.println("\nLogin successful!");
            System.out.println("Welcome, " + userData[1] + "!");

            return true;

        } else {

            System.out.println(
                "\nInvalid email or password."
            );

            return false;
        }
    }


    // ========================================================
    // LOGOUT
    // ========================================================
    public void logout() {

        if (loggedIn) {

            loggedIn = false;

            System.out.println(
                "\n" + userData[1] +
                " has successfully logged out."
            );

        } else {

            System.out.println(
                "\nYou are not logged in."
            );
        }
    }


    public boolean isLoggedIn() {
        return loggedIn;
    }


    public String getUsername() {
        return userData[1];
    }


    public String getPassword() {
        return userData[2];
    }


    public String getEmail() {
        return userData[0];
    }


    // ========================================================
    // UPDATE USERNAME
    // ========================================================
    public void setUsername(String newUsername) {
        userData[1] = newUsername;
    }


    // ========================================================
    // UPDATE PASSWORD
    // ========================================================
    public void setPassword(String newPassword) {
        userData[2] = newPassword;
    }  
}
