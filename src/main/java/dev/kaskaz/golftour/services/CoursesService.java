package dev.kaskaz.golftour.services;

import dev.kaskaz.golftour.models.Course;
import dev.kaskaz.golftour.repositories.CoursesRepository;

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

    public Course getById(Integer id) throws SQLException {
        return coursesRepository.getById(id);
    }

    public int create(Course course) throws SQLException {
        return coursesRepository.add(course);
    }

    public int create(List<Course> courses) throws SQLException {
        return coursesRepository.add(courses);
    }
}
