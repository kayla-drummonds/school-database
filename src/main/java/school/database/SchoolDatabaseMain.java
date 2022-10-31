package school.database;

// import java.util.Date;
import java.util.List;

import school.database.dao.CourseDAO;
import school.database.dao.DepartmentDAO;
import school.database.dao.StudentCourseDAO;
import school.database.dao.StudentDAO;
import school.database.entity.Course;
import school.database.entity.Department;
import school.database.entity.Student;
import school.database.entity.StudentCourse;

public class SchoolDatabaseMain {
    public static void main(String[] args) {

	CourseDAO courseDAO = new CourseDAO();
	DepartmentDAO departmentDAO = new DepartmentDAO();
	StudentDAO studentDAO = new StudentDAO();
	StudentCourseDAO studentCourseDAO = new StudentCourseDAO();

	List<Course> cByLetter = courseDAO.findByNameStartsWith("E");
	System.out.println("=========================== Find Course By Name Starting With Letter ===========================");
	for (Course c : cByLetter) {
	    System.out.println("Course id: " + c.getId() + " | Name: " + c.getName() + " | Department id: "
		    + c.getDepartment().getId() + " | Department name: " + c.getDepartment().getName());
	}

	Department dByName = departmentDAO.findByName("Business");
	System.out.println("=========================== Find Department By Name ===========================");
	System.out.println("Department id: " + dByName.getId() + " | Name: " + dByName.getName());
	
	Student sById = studentDAO.findById(2);
	System.out.println("=========================== Find Student By ID ===========================");
	System.out.println("Student id: " + sById.getId() + " | First Name: " + sById.getFirstName() + " | Last Name: " + sById.getLastName()
		+ " | Street: " + sById.getStreet() + " | City: " + sById.getCity() + " | State: " + sById.getState() + " | Postal Code: "
		+ sById.getPostalCode() + " | Major Department: " + sById.getDepartment().getName());
	
	// StudentCourse newSC = new StudentCourse();
	Student sById2 = studentDAO.findById(7);
	/*
	 * Course cById = courseDAO.findById(4); newSC.setStudent(sById2);
	 * newSC.setCourse(cById); newSC.setProgress(95.2); newSC.setStartDate(new
	 * Date()); studentCourseDAO.insert(newSC);
	 */
	
	List<StudentCourse> scByStudentId = studentCourseDAO.findByStudentId(sById2.getId());
	System.out.println("=========================== Find Student Courses By Student ID ===========================");
	for(StudentCourse sc : scByStudentId) {
	    System.out.println("Student ID: " + sc.getStudent().getId() + " | Course ID: " + sc.getCourse().getId() + " | Progress: " 
		    + sc.getProgress() + " | Start Date: " + sc.getStartDate());
	}
    }
}
