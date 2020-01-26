package controllers;

import io.javalin.http.Context;
import models.Course;
import services.CoursesService;

import java.util.ArrayList;
import java.util.List;

public class CoursesController {

    public void listCourses(Context context) throws Exception {
        context.json(new CoursesService().getAll());
    }

    public void getDetails(Context context) throws Exception {
        CoursesService service = new CoursesService();
        List<Double> ids = context.bodyAsClass(ArrayList.class);
        List<Course> courses = new ArrayList<>();
        ids.forEach(id -> {
            try {
                courses.add(service.getById(id.intValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        context.json(courses);
    }
}
