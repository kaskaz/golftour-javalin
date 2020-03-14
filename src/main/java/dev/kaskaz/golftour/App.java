package dev.kaskaz.golftour;

import com.google.gson.Gson;
import io.javalin.Javalin;
import io.javalin.plugin.json.JavalinJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static void main(String[] args) throws Exception {

        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Starting server");

        Javalin app = Javalin.create()
            .start(getHerokuAssignedPort());

        Gson gson = new Gson();
        JavalinJson.setToJsonMapper(gson::toJson);
        JavalinJson.setFromJsonMapper(gson::fromJson);

        new GolfTourBootstrap(app);
    }

    private static int getHerokuAssignedPort() {
        String herokuPort = System.getenv("PORT");
        if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
        }
        return 7000;
    }


}
