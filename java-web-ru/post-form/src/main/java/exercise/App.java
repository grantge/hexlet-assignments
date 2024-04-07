package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import exercise.util.Security;

public final class App {

    public static List<User> entities = new ArrayList<User>();

    public static Javalin getApp() {



        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            var page = new UsersPage(users);
            ctx.render("users/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");

            System.out.println(UserRepository.getEntities());
        });

        app.post("/users", ctx -> {
            String firstName = ctx.formParam("firstName");
            String lastName = ctx.formParam("lastName");
            String email = ctx.formParam("email");
            String pass = ctx.formParam("password");

            pass = selfPass(pass);
            firstName = capitalize(firstName);
            lastName = capitalize(lastName);
            email = normalizeEmail(email);

            User user = new User(firstName, lastName, email, pass);

            UserRepository.save(user);
            System.out.println(UserRepository.getEntities());
            ctx.redirect("/users");
        });
        // END

        return app;
    }

    private static String capitalize(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private static String selfPass(String pass) {
        return Security.encrypt(pass);

    }

    private static String normalizeEmail(String email) {
        return email.toLowerCase().trim();

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
