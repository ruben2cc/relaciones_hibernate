package com.benito.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.benito.hibernate.Instructor;
import com.benito.hibernate.InstructorDetail;

public class UnoAUnoTestUpdate {

	public static void main(String[] args) {

		SessionFactory sessionFactory= new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			int theId=1;
			session.beginTransaction();
			
			// Leer instructor 
			Instructor instructor = session.get(Instructor.class, theId);
			
			// mostrar instructor
			System.out.println(instructor);
			
			// mostrar instructor detail
			System.out.println(instructor.getDetails());
			
			// actualizar hobby
			instructor.getDetails().setHobby("Video juegos");
			
			// mostrar instructor detail
			System.out.println(instructor.getDetails());
			
			// actualizando 
			System.out.println("Actualizando...");
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
		
	}

}
