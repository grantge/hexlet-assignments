package exercise;

import io.javalin.Javalin;

import java.util.List;
import java.util.Map;

import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            var page = new UsersPage(USERS);

            ctx.render("users/index.jte", model("page", page));

        });

        app.get("/users", ctx -> {
            var page = new UsersPage(USERS);

            ctx.render("users/index.jte", model("page", page));

        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");

            var user = getUser(Integer.parseInt(id));
            var page = new UserPage(user);

            if (user == null) {
                throw new NotFoundResponse("User not found");
            }

            ctx.render("users/show.jte", model("page", page));
        });

        return app;
    }

    private static User getUser(int id) {

        User u = null;
        
        for (User user : USERS) {
            if (user.getId() == id) {
                u = user;
            }
        }
        return u;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
