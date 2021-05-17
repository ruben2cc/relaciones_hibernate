package com.benito.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.benito.hibernate.Instructor;
import com.benito.hibernate.InstructorDetail;

public class UnoAUnoTestRead {

	public static void main(String[] args) {

		SessionFactory sessionFactory= new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			int theId=3;
			session.beginTransaction();
			
			// Leer instructor  detail
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			
			// mostrar instructor detail
			System.out.println(instructorDetail);
			
			// mostrar instructor
			System.out.println(instructorDetail.getInstructor());
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
		
	}

}
