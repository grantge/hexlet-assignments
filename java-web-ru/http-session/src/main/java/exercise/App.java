package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create()

                .get("/users", ctx -> {
                    int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
                    int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

                    ctx.json(App.res(page, per));
                });

        return app;

    }

    private static List<Map<String, String>> res(int page, int per) {

        int result = page * per - per;
        List<Map<String, String>> resList = new ArrayList<>();;

        for(int i = 0; i < per ; i++) {

            resList.add(USERS.get(result));
            result += 1;
        }


        return resList;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
