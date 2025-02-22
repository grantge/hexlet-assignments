package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import  org.springframework.beans.factory.annotation.Autowired;

import exercise.model.User;
import exercise.component.UserProperties;

@SpringBootApplication
@RestController
public class Application {

    // Все пользователи
    private List<User> users = Data.getUsers();
    @Autowired
    private UserProperties userProperties;

    // BEGIN
    @GetMapping("/admins")
    public List<String> getAdmins() {

        List<String> res = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < userProperties.getAdmins().size(); j++) {
                if (Objects.equals(users.get(i).getEmail(), userProperties.getAdmins().get(j))) {
                    res.add(users.get(i).getName());
                }
            }
        }


        return res.stream().sorted().toList();
    }
    // END

    @GetMapping("/users")
    public List<User> index() {
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable Long id) {
        var user = users.stream()
            .filter(u -> u.getId() == id)
            .findFirst();
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
