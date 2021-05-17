package com.benito.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UnoAUnoTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory= new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor instructor = new Instructor("Ruben", "Benito", "ruben2cc@gmail.com");
			InstructorDetail detail = new InstructorDetail("http://www.youtube.com.¿/ruben2cc", "chess");
			
			instructor.setDetails(detail);
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
		
	}

}
