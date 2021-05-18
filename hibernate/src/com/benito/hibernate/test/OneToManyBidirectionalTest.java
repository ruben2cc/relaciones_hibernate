package com.benito.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.benito.hibernate.Course;
import com.benito.hibernate.Instructor;
import com.benito.hibernate.InstructorDetail;




public class OneToManyBidirectionalTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 2);

			Course course = new Course("Algebra");
			
			instructor.addCourse(course);
			
			session.save(course);

			// confirmar la transaccion
			session.getTransaction().commit();

		} finally {
			session.close();
		}

	}

}
