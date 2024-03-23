package exercise;

import io.javalin.Javalin;


public final class App {

    public static Javalin getApp() {


        var app = Javalin.create(/*config*/)
                .get("/phones", ctx -> ctx.json(Data.getPhones()))
                .get("/domains", ctx -> ctx.json(Data.getDomains()));

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
