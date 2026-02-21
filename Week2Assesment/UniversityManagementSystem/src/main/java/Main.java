package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Department dept = new Department();
        dept.setName("Computer Science");

        Student s1 = new Student();
        s1.setName("Avinash");

        Student s2 = new Student();
        s2.setName("Rahul");

        s1.setDepartment(dept);
        s2.setDepartment(dept);
        dept.setStudents(Arrays.asList(s1, s2));

        IDCard id1 = new IDCard();
        id1.setCardNumber("CS101");

        IDCard id2 = new IDCard();
        id2.setCardNumber("CS102");

        s1.setIdCard(id1);
        s2.setIdCard(id2);

        Course c1 = new Course();
        c1.setCourseName("Java");

        Course c2 = new Course();
        c2.setCourseName("Database");

        s1.setCourses(Arrays.asList(c1, c2));
        s2.setCourses(Arrays.asList(c1));

        session.save(dept);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Success!");
    }
}