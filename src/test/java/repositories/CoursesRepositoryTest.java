package repositories;

import models.Course;
import org.junit.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoursesRepositoryTest {

    private static CoursesRepository coursesRepository;

    private final String testName1 = "name 1";
    private final String testName2 = "name 2";

    @BeforeClass
    public static void setUp() throws Exception {
        Database.init();
        coursesRepository = new CoursesRepository();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Database.close();
    }

    @Test
    public void testAddAndGetCourse() throws SQLException {
        Course course = new Course();
        course.setName(testName1);

        int courseId = coursesRepository.add(course);
        Course persistedCourse = coursesRepository.getById(courseId);

        assertEquals(testName1, persistedCourse.getName());

    }

    @Test
    public void testGetAll() throws SQLException {
        Course course1 = new Course();
        course1.setName(testName1);

        Course course2 = new Course();
        course2.setName(testName2);

        coursesRepository.add(course1);
        coursesRepository.add(course2);

        List<Course> list = coursesRepository.getAll();
        assertTrue(list.stream().anyMatch(course -> course.getName().contentEquals(testName1)));
        assertTrue(list.stream().anyMatch(course -> course.getName().contentEquals(testName2)));

    }

}
