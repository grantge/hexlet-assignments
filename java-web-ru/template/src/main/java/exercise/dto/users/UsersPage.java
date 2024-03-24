package exercise.dto.users;

import exercise.model.User;

import java.util.List;

public class UsersPage {
    private final List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public UsersPage(List<User> users) {
        this.users = users;
    }

}
