package dev.kaskaz.golftour.repositories;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import dev.kaskaz.golftour.models.Course;

import java.sql.SQLException;
import java.util.List;

public class CoursesRepository {

    private Dao<Course,Integer> courseDao;

    public CoursesRepository() throws Exception {
        courseDao = DaoManager
            .createDao(Database.getInstance().getConnection(), Course.class);
    }

    public List<Course> getAll() throws SQLException {
        return courseDao.queryForAll();
    }

    public Course getById(int id) throws SQLException {
        return courseDao.queryForId(id);
    }

    public int add(Course course) throws SQLException {
        return courseDao.create(course);
    }

    public int add(List<Course> courses) throws SQLException {
        return courseDao.create(courses);
    }
}
