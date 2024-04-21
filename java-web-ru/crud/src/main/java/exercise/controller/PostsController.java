package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {

        Long name = Long.valueOf(ctx.pathParam("name"));
        Optional<Post> post = PostRepository.find(name);

        System.out.println(post);

        if (post.isEmpty()) {
            throw new NotFoundResponse("Page not found");
        }
        var page = new PostPage(post.get());

        ctx.render("posts/show.jte", model("page", page));

    }

    public static void showAll(Context ctx) {

        String p = ctx.queryParam("page");
        int num = p == null ? 1 : Integer.parseInt(p);

        var first = num * 5 - 5;
        var last = num * 5;

        List<Post> posts = PostRepository.getEntities();
        ArrayList<Post> newPosts = new ArrayList<>();

        for (int i = first; i < last; i++) {
            newPosts.add(posts.get(i));
        }

        var page = new PostsPage(newPosts);

        ctx.render("posts/index.jte", model("page", page));
    }
    // END
}
