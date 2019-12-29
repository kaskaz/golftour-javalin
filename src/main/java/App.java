import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create()
            .start(getHerokuAssignedPort())
            .get("/", ctx -> ctx.result("Hello Heroku"));
    }

    private static int getHerokuAssignedPort() {
        String herokuPort = System.getenv("PORT");
        if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
        }
        return 7000;
    }
}
