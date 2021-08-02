package Models;

public class User implements IModel {
    public String UserID;
    public String UserName;
    public String Designation;
    private String Password;

    public User() {
    }

    public User(
            String _userId,
            String _username,
            String _designation,
            String _password
    ) {
        UserName = _username;
        UserID = _userId;
        Designation = _designation;
        Password = _password;
    }

    @Override
    public String insertStatement() {
        return UserID+", '"+UserName+"', '"+Password+"', "+Designation;
    }

}
