package com.benito.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.benito.hibernate.Instructor;
import com.benito.hibernate.InstructorDetail;

public class UnoAUnoDelete {

	public static void main(String[] args) {

		SessionFactory sessionFactory= new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();

			// leer el instructor 
			Instructor instructor = session.get(Instructor.class, 1);
			
			// eliminar el instructor
			session.delete(instructor);
			
			// confirmar la transaccion
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
		
	}

}
