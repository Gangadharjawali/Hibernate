package com.hibernate.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
	public static void main(String args[]) {

		Student_Info student = new Student_Info();
		student.setName("gangadhar");
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		//config.addAnnotatedClass(Student_Info.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
