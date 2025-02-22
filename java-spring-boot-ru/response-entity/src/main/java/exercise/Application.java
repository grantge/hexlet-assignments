package exercise;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<List<Post>> getPosts(@RequestParam(defaultValue = "10") Integer limit) {

        List<Post> body = posts.stream().limit(limit).toList();

        return ResponseEntity.status(200)
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(body);
    }
    @GetMapping("/posts/{id}")
    public ResponseEntity <Optional<Post>> getPost(@PathVariable String id) {
        int statusCode;

        var maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (maybePost.isPresent()) {
            statusCode = 200;
        } else {
            statusCode = 404;
        }
        return ResponseEntity.status(statusCode).body(maybePost);
    }
    @PostMapping("/posts")
    public ResponseEntity <Post> createPost(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.status(201).body(post);
    }
    @PutMapping("/posts/{id}")
    public  ResponseEntity <Post> updatePost(@PathVariable String id, @RequestBody Post data) {
        int statusCode;
        var maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (maybePost.isPresent()) {
            statusCode = 200;
            Post post = maybePost.get();
            post.setTitle(data.getTitle());
            post.setBody(data.getBody());
        } else {
            statusCode = 204;
        }
        return ResponseEntity.status(statusCode).body(data);
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
