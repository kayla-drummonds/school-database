package school.database.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import school.database.entity.Department;

public class DepartmentDAO {

    SessionFactory factory;
    Session session;
    Transaction t;
    
    public DepartmentDAO() {
	this.factory = null;
	this.session = null;
	this.t = null;
    }
    
    public Department findByName(String name) {
	factory = new Configuration().configure().buildSessionFactory();
	session = factory.openSession();
	t = session.beginTransaction();
	
	String hql = "from Department d where d.name = :deptName";
	TypedQuery<Department> query = session.createQuery(hql, Department.class);
	query.setParameter("deptName", name);
	
	Department result = query.getSingleResult();
	
	t.commit();
	factory.close();
	session.close();
	
	return result;
    }
 }
