package sangre.project.product.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sangre.project.product.dom.Employee;

public class EmployeeDao {

	private final SessionFactory sessionFactory;

	public EmployeeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void add(Employee newEmployee) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(newEmployee);
			transaction.commit();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
