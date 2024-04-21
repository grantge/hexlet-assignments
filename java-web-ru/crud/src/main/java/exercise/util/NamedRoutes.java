package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postPath() {return "/posts/{name}";}

    public static String postsPath() {return "/posts";}
    // END
}
