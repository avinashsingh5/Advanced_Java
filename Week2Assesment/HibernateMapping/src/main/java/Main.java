import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");


        cfg.addAnnotatedClass(Department.class);
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(IDCard.class);
        cfg.addAnnotatedClass(Course.class);


        SessionFactory factory = cfg.buildSessionFactory();


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


        IDCard c1 = new IDCard();
        c1.setCardNumber("ID101");

        IDCard c2 = new IDCard();
        c2.setCardNumber("ID102");

        s1.setIdCard(c1);
        s2.setIdCard(c2);


        Course java = new Course();
        java.setCourseName("Java");

        Course db = new Course();
        db.setCourseName("Database");

        s1.setCourses(Arrays.asList(java, db));
        s2.setCourses(Arrays.asList(java));


        session.persist(dept);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Data Saved Successfully");
    }
}