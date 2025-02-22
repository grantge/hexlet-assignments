package exercise.controller.users;

import java.util.List;
import java.util.Optional;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping("/api/users/{id}/posts")
    public ResponseEntity <List<Post>> getPosts(@PathVariable int id) {

        return ResponseEntity
                .status(200)
                .body(posts.stream().filter(post -> post.getUserId() == id).toList());

    }
    @PostMapping("/api/users/{id}/posts")
    public ResponseEntity <Post> createPost(@PathVariable int id, @RequestBody Post data) {

        Post newPost = new Post();
        newPost.setBody(data.getBody());
        newPost.setTitle(data.getTitle());
        newPost.setSlug(data.getSlug());
        newPost.setUserId(id);
        posts.add(newPost);

        return ResponseEntity.status(201).body(newPost);
    }
}
// END
