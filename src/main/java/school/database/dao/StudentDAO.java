package school.database.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import school.database.entity.Student;

public class StudentDAO {
    SessionFactory factory;
    Session session;
    Transaction t;
    
    public StudentDAO() {
	this.factory = null;
	this.session = null;
	this.t = null;
    }

    public Student findById(Integer id) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	String hql = "from Student s where s.id = :studentId";
	TypedQuery<Student> query = session.createQuery(hql, Student.class);
	query.setParameter("studentId", id);
	
	Student result = query.getSingleResult();
	
	t.commit();
	factory.close();
	session.close();
	
	return result;
    }
    
}
