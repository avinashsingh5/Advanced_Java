import java.sql.*;

public class Demo {

    static String url = "jdbc:mysql://localhost:3306/school";
    static String user = "root";
    static String pass = "avinash";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful!");

            // CREATE
            insertStudent(con, "Rahul", 22);

            // READ
            readStudents(con);

            // UPDATE
            updateStudent(con, 1, 25);

            // DELETE
            deleteStudent(con, 1);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // INSERT
    public static void insertStudent(Connection con, String name, int age) throws SQLException {
        String query = "INSERT INTO student(name, age) VALUES(?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.executeUpdate();
        System.out.println("Record Inserted!");
    }

    // READ
    public static void readStudents(Connection con) throws SQLException {
        String query = "SELECT * FROM student";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("Student Records:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getInt("age")
            );
        }
    }

    // UPDATE
    public static void updateStudent(Connection con, int id, int newAge) throws SQLException {
        String query = "UPDATE student SET age=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, newAge);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Record Updated!");
    }

    // DELETE
    public static void deleteStudent(Connection con, int id) throws SQLException {
        String query = "DELETE FROM student WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Record Deleted!");
    }
}
