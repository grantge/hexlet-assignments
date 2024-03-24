package exercise;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/companies/{id}", ctx -> {

            if (App.getResult(ctx.pathParam("id")).isEmpty()) {
                throw new NotFoundResponse("Company not found");
            } else {
                ctx.json(App.getResult(ctx.pathParam("id")));
            }

        });

        return app;

    }

    private static Map<String, String> getResult(String id) {

        Map<String, String> res = new HashMap<>();

        for (Map<String, String> company : COMPANIES) {

            if (company.get("id").equals(id)) {
                res.putAll(company);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
