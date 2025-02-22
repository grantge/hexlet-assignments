package exercise;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public List<Post> getPosts(@RequestParam(defaultValue = "10") Integer limit) {
        return posts.stream().limit(limit).toList();
    }
    @GetMapping("/posts/{id}")
    public Optional<Post> getPost(@PathVariable String id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();

    }
    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        posts.add(post);
        return post;
    }
    @PutMapping("/posts/{id}")
    public  Post updatePost(@PathVariable String id, @RequestBody Post data) {
        var maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (maybePost.isPresent()) {
            Post post = maybePost.get();
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
        }
        return data;
    }
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable String id) {

        posts.removeIf(p -> p.getId().equals(id));
    }
    // END
}

//GET /posts — список всех постов
//GET /posts/{id} — просмотр конкретного поста
//POST /posts – создание нового поста
//PUT /posts/{id} – обновление поста
//DELETE /posts/{id} – удаление поста
