import com.opencsv.bean.CsvToBeanBuilder;
import controllers.CoursesController;
import io.javalin.Javalin;
import models.Course;
import repositories.CoursesRepository;
import repositories.Database;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;


public class GolfTourBootstrap {

    public GolfTourBootstrap(Javalin app) throws Exception {
        start(app);
    }

    private void start(Javalin app) throws Exception {

        initDatabase();

        CoursesController coursesController = new CoursesController();

        app.before(ctx -> {
            ctx.header("Access-Control-Allow-Origin", "*");
        });

        app.routes(() -> {
           path("courses", () -> {
               get("list", coursesController::listCourses);
               post("details", coursesController::getDetails);
           });
        });

        app.routes(() -> {

        });

    }

    private void initDatabase() throws Exception {

        List<Course> courses = getCollectionFromCsvFile("COURSES.csv", Course.class);


        Database.init();

        CoursesRepository coursesRepository = new CoursesRepository();
        courses.forEach(course -> {
            try {
                coursesRepository.add(course);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    private List getCollectionFromCsvFile(String filename, Class clazz) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(filename);
        InputStreamReader reader = new InputStreamReader(is);


        CsvToBeanBuilder builder = new CsvToBeanBuilder(reader);
        return builder.withType(clazz)
            .withSeparator(';')
            .build()
            .parse();
    }

}
