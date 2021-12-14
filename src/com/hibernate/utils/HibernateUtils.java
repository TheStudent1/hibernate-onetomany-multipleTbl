package com.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.app.model.Lesson;
import com.app.model.Monitor;
import com.app.model.Student;
import com.app.model.Vehicle;

public class HibernateUtils {

	private static final SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static {
		Configuration config = new Configuration();
		config.configure();

		config.addAnnotatedClass(Monitor.class);
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(Vehicle.class);
		config.addAnnotatedClass(Lesson.class);

		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
