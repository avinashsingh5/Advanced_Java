package org.example;
import org.example.MenuItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Scanner;

public class MenuItemMain {

    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();


    public static void saveItem(MenuItem item) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(item);
            tx.commit();
        }
    }


    public static MenuItem getItem(int id) {
        try (Session session = factory.openSession()) {
            return session.get(MenuItem.class, id);
        }
    }


    public static void getAllItems() {
        try (Session session = factory.openSession()) {
            List<MenuItem> list = session.createQuery("from MenuItem", MenuItem.class).list();
            list.forEach(System.out::println);
        }
    }


    public static void updatePrice(int id, double newPrice) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            MenuItem item = session.get(MenuItem.class, id);
            if (item != null) {
                item.setPrice(newPrice);
                session.merge(item);
            }
            tx.commit();
        }
    }


    public static void deleteItem(int id) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            MenuItem item = session.get(MenuItem.class, id);
            if (item != null) session.remove(item);
            tx.commit();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome");
            System.out.println("1. Add Menu Item");
            System.out.println("2. View Item By ID");
            System.out.println("3. View All Items");
            System.out.println("4. Update Price");
            System.out.println("5. Delete Item");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Available: ");
                    boolean available = sc.nextBoolean();

                    saveItem(new MenuItem(name, price, category, available));
                    System.out.println("Menu Item Added!");
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    MenuItem item = getItem(id);
                    System.out.println(item != null ? item : "Item Not Found");
                    break;

                case 3:
                    getAllItems();
                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    updatePrice(uid, newPrice);
                    System.out.println("Price Updated!");
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();

                    deleteItem(did);
                    System.out.println("Item Deleted!");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
        factory.close();
    }
}
