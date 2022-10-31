package school.database.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import school.database.entity.Course;

public class CourseDAO {

    SessionFactory factory;
    Session session;
    Transaction t;
    
    public CourseDAO() {
	this.factory = null;
	this.session = null;
	this.t = null;
    }
    
    public List<Course> findByNameStartsWith(String letter) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	String hql = "from Course c where c.name like :letter";
	TypedQuery<Course> query = session.createQuery(hql, Course.class);
	query.setParameter("letter", letter + "%");
	
	List<Course> results = query.getResultList();
	
	t.commit();
	factory.close();
	session.close();
	
	return results;
    }

    public Course findById(Integer id) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	String hql = "from Course c where c.id = :courseId";
	TypedQuery<Course> query = session.createQuery(hql, Course.class);
	query.setParameter("courseId", id);
	
	Course result = query.getSingleResult();
	
	t.commit();
	factory.close();
	session.close();
	
	return result;
    }
}
