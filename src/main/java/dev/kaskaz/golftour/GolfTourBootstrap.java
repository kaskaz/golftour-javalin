package dev.kaskaz.golftour;

import com.opencsv.bean.CsvToBeanBuilder;
import dev.kaskaz.golftour.controllers.AccommodationsController;
import dev.kaskaz.golftour.controllers.CoursesController;
import dev.kaskaz.golftour.models.Accommodation;
import dev.kaskaz.golftour.models.Course;
import dev.kaskaz.golftour.repositories.Database;
import dev.kaskaz.golftour.services.AccommodationsService;
import dev.kaskaz.golftour.services.CoursesService;
import io.javalin.Javalin;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;


public class GolfTourBootstrap {

    public GolfTourBootstrap(Javalin app) throws Exception {
        start(app);
    }

    private void start(Javalin app) throws Exception {

        initDatabase();

        CoursesController coursesController = new CoursesController();
        AccommodationsController accommodationsController = new AccommodationsController();

        app.config.enableCorsForAllOrigins();

        app.before(ctx -> {
            ctx.header("Access-Control-Allow-Origin", "*");
            ctx.header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
            ctx.header("Access-Control-Allow-Headers", "Content-Type");
        });

        app.after(ctx -> {
            if (ctx.method().equals("OPTIONS"))
                ctx.status(200);
        });

        app.routes(() -> {
           path("courses", () -> {
               get("list", coursesController::listCourses);
               post("details", coursesController::getDetails);
           });
        });

        app.routes(() -> {
            path("accommodations", () -> {
                get("details", accommodationsController::getDetails);
                post("near", accommodationsController::getNear);
            });
        });

    }

    private void initDatabase() throws Exception {

        List<Course> courses = getCollectionFromCsvFile("COURSES.csv", Course.class);
        List<Accommodation> accommodations = getCollectionFromCsvFile("ACCOMMODATIONS.csv", Accommodation.class);

        Database.init();

        CoursesService coursesService = new CoursesService();
        coursesService.create(courses);

        AccommodationsService accommodationsService = new AccommodationsService();
        accommodationsService.create(accommodations);

    }

    private List getCollectionFromCsvFile(String filename, Class clazz) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader reader = new InputStreamReader(is);

        CsvToBeanBuilder builder = new CsvToBeanBuilder(reader);
        return builder.withType(clazz)
            .withSeparator(';')
            .build()
            .parse();
    }

}
