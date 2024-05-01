package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class).get();
        var body = ctx.formParamAsClass("body", String.class).get();

        try {
            var nameValid = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "error")
                    .get();

            var bodyValid = ctx.formParamAsClass("body", String.class).get();

            var post = new Post(nameValid, bodyValid);
            PostRepository.save(post);
            ctx.sessionAttribute("flash", "Пост был успешно создан!");
            ctx.redirect(NamedRoutes.postsPath());

        } catch (ValidationException e) {
            var page = new BuildPostPage(name, body, e.getErrors());

            ctx.render("posts/build.jte", model("page", page));
        }
    }

    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();

        var flash = ctx.consumeSessionAttribute("flash");
        // Добавляем flash в определение CoursesPage
        var page = new PostsPage(posts);
        page.setFlash((String) flash);

        ctx.render("posts/index.jte", model("page", page));
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
