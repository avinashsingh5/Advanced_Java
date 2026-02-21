package org.example.oto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class OneToOneMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        while (true){
            System.out.println("1.Add Person & Passport");
            System.out.println("2.exit");
            System.out.println("Enter what you want to do!");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter PassportNumber: ");
                    int passNum = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Country: ");
                    String countryName = sc.nextLine();

                    Session session = factory.openSession();
                    Transaction trx = session.beginTransaction();

                    Passport p = new Passport(passNum, countryName);
                    Person person = new Person(name, p);
                    session.persist(person);
                    trx.commit();
                    session.close();

                    System.out.println("Passport and person saved");
                    break;
                case 2:
                    factory.close();
                    sc.close();
                    System.out.println("Closing");
                    return;
                default:
                    System.out.println("Enter Valid Number");
            }
        }
    }
}