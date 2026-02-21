package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);

        // Build session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Create a new student
        Student student = new Student();
        student.setName("Avinash");
        student.setAge(22);

        // Save student to DB
        session.save(student);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        System.out.println("Student saved: " + student);
    }
}
