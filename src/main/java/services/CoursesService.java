package services;

import models.Course;
import repositories.CoursesRepository;

import java.sql.SQLException;
import java.util.List;

public class CoursesService {

    private CoursesRepository coursesRepository;

    public CoursesService() throws Exception {
        this.coursesRepository = new CoursesRepository();
    }

    public List<Course> getAll() throws SQLException {
        return coursesRepository.getAll();
    }

    public Course getById(Integer id) throws Exception {
        return coursesRepository.getById(id);
    }
}
