package school.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import school.database.entity.Course;

public class CourseDAOTest {

    private static CourseDAO courseDAO;
    
    @BeforeAll
    public static void setUp() {
	courseDAO = new CourseDAO();
    }
    
    @Test
    public void testGetCourseById() {
	Course expected = new Course();
	expected.setId(1);
	expected.setName("Accounting & Finance");
	expected.setDepartment(2);
	
	Course actual = courseDAO.findById(1);
	Assertions.assertEquals(expected, actual);
	Assertions.assertEquals(expected.getName(), actual.getName());
	Assertions.assertEquals(expected.getDepartment(), actual.getDepartment());
	
    }
    
    @Test
    public void testFindByNameStartsWith() {
	Course expected = new Course();
	expected.setId(58);
	expected.setName("Nursing");
	expected.setDepartment(6);
	
	List<Course> expectedCourses = new ArrayList<>();
	expectedCourses.add(expected);
	
	List<Course> actualCourses = courseDAO.findByNameStartsWith("N");
	
	Assertions.assertTrue(actualCourses.size() == 1);
	
	Course actualCourse = actualCourses.get(0);
	Assertions.assertEquals(expectedCourses, actualCourses);
	Assertions.assertEquals(expected.getName(), actualCourse.getName());
	Assertions.assertEquals(expected.getDepartment(), actualCourse.getDepartment());
	
    }
}
