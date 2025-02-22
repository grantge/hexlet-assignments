package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;

class AppTest {

    private static Javalin app;
    private static String baseUrl;

    @BeforeAll
    public static void beforeAll() {
        app = App.getApp();
        app.start(0);
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }

    @Test
    void testLoginPass() throws Exception {
        HttpResponse<String> response1 = Unirest.get(baseUrl + "/").asString();
        assertThat(response1.getStatus()).isEqualTo(200);
        var body1 = response1.getBody();
        System.out.println(body1);
        assertThat(body1).contains("IN");
        assertThat(body1).doesNotContain("Выйти");

        HttpResponse<String> response2 = Unirest
            .get(baseUrl + "/sessions/build").asString();
        assertThat(response2.getStatus()).isEqualTo(200);

        HttpResponse<String> responsePost = Unirest
            .post(baseUrl + "/sessions")
            .field("name", "admin")
            .field("password", "secret")
            .asEmpty();

        assertThat(responsePost.getStatus()).isEqualTo(302);

        HttpResponse<String> response3 = Unirest.get(baseUrl + "/").asString();
        var body3 = response3.getBody();
        assertThat(response3.getStatus()).isEqualTo(200);
        assertThat(body3).contains("OUT");
        assertThat(body3).doesNotContain("IN");
        assertThat(body3).contains("admin");

        HttpResponse<String> responseDelete = Unirest
            .post(baseUrl + "/sessions/delete")
            .asEmpty();
        assertThat(responseDelete.getStatus()).isEqualTo(302);

        HttpResponse<String> response4 = Unirest.get(baseUrl + "/").asString();
        var body4 = response4.getBody();
        assertThat(body4).contains("IN");
        assertThat(body4).doesNotContain("OUT");
    }

    @Test
    void testLoginFail1() throws Exception {

        HttpResponse<String> responsePost = Unirest
            .post(baseUrl + "/sessions")
            .field("name", "noname")
            .field("password", "secret")
            .asString();

        var body = responsePost.getBody();
        assertThat(body).contains("Wrong");
    }

    @Test
    void testLoginFail2() throws Exception {

        HttpResponse<String> responsePost = Unirest
            .post(baseUrl + "/sessions")
            .field("name", "admin")
            .field("password", "wrong_password")
            .asString();

        var body = responsePost.getBody();
        assertThat(body).contains("Wrong");
    }

    @AfterAll
    public static void afterAll() {
        app.stop();
    }
}
