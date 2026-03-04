import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    // TODO Now: Add a constructor to initialize the users list with the default user

    public AuthenticationService(ArrayList<User> users){
        this.users = users;
    }



    @Override
    public User signUp(String username, String password) {
        boolean exists = users.stream().anyMatch(u -> u.getUsername().equals(username));
        if (exists) return null;
        User newUser = new User(username, password);
        users.add(newUser);
        return  newUser;
    }

    @Override
    public User logIn(String username, String password) {
        for (User user: users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password))
                    return user;
                else
                    return  null;
            }
        }
        return null;
    }


}
