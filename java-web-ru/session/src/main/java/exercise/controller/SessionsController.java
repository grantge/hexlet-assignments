package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void root(Context ctx) {

        var page = new MainPage(UsersRepository.findByName(ctx.sessionAttribute("currentUser")));
        ctx.render("index.jte", model("page", page));
    }

     public static void build(Context ctx) {
//         var page = new LoginPage(ctx.sessionAttribute("currentUser"));
         ctx.render("build.jte");
     }

    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class).get();
        var password = encrypt(ctx.formParamAsClass("password", String.class).get());

        if (UsersRepository.existsByName(name) && password.equals(UsersRepository.findByName(name).getPassword())) {
            ctx.sessionAttribute("currentUser", name);

            var page = new MainPage(name);
            ctx.status(302);
            ctx.render("index.jte", model("page", page));

        } else  {
            var page = new LoginPage(name, "Wrong username or password.");
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);

        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
