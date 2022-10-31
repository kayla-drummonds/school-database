package school.database.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import school.database.entity.StudentCourse;

public class StudentCourseDAO {

    SessionFactory factory;
    Session session;
    Transaction t;
    
    public StudentCourseDAO() {
	this.factory = null;
	this.session = null;
	this.t = null;
    }

    public void insert(StudentCourse sc) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	session.save(sc);
	
	t.commit();
	System.out.println("Successfully registered student to course.");
	factory.close();
	session.close();
    }
    
    public List<StudentCourse> findByStudentId(Integer studentId) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	String hql = "from StudentCourse sc where sc.student.id = :studentId";
	TypedQuery<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
	query.setParameter("studentId", studentId);
	
	List<StudentCourse> results = query.getResultList();
	
	t.commit();
	factory.close();
	session.close();
	
	return results;
    }
}
