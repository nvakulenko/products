package sangre.project.product.dao;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sangre.project.product.dom.Employee;

public class EmployeeDaoTest {

	private EmployeeDao employeeDao;

	@BeforeClass
	public void setUp() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		employeeDao = new EmployeeDao(sessionFactory);
	}

	@Test
	public void testAddEmployee() {
		Employee newEmployee = new Employee();
		newEmployee.setName("John Dow");
		newEmployee.setTitle("Manager");
		newEmployee.setBirthDate(new Date(1988, 2, 14));
		newEmployee.setHireDate(new Date(2013, 9, 28));
		newEmployee.setAddress("NY, 5th avenue");
		newEmployee.setHomePhone("123-456-789");
		newEmployee.setNotes("Good employee");

		employeeDao.add(newEmployee);

	}
}
