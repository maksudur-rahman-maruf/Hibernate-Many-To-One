
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

public class StoredData {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("Ravi Malik");
		e1.setEmail("ravi@gmail.com");

		Employee e2 = new Employee();
		e2.setName("Ikhwan Rafi");
		e2.setEmail("rafi@gmail.com");

		Address address1 = new Address();
		address1.setAddressLine1("G-21,Lohia nagar");
		address1.setCity("Ghaziabad");
		address1.setState("UP");
		address1.setCountry("India");
		address1.setPincode(201301);

		e1.setAddress(address1);
		e2.setAddress(address1);

		session.persist(e1);
		session.persist(e2);

		t.commit();
		session.close();
		System.out.println("success");

	}

}
