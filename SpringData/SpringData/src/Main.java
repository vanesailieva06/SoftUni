import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class Main {
    private static Connection connection;
    private static Scanner scanner;
    private static int countMinions;
    public static void main(String[] args) throws SQLException {
        scanner = new Scanner(System.in);
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "Vanesa06");
        connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);
        System.out.println("Enter exercise: ");
        int exercise = Integer.parseInt(scanner.nextLine());

        switch (exercise){
            case 2: exTwo();
            case 3: exThree();
            case 4: exFour();
        }

    }

    private static void exFour() {

    }

    private static void exTwo() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT v.name, COUNT(DISTINCT mv.minion_id) minions_count FROM villains v " +
            "JOIN minions_villains mv on v.id = mv.villain_id " +
            "GROUP BY v.name " +
            "HAVING minions_count > 15 " +
            "ORDER BY  minions_count DESC;");
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            System.out.printf("%s %d", rs.getString("name"), rs.getInt("minions_count"));
        }

    }
    private static void exThree() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT v.name, m.name minion_name, m.age FROM villains v " +
                "JOIN minions_villains mv on v.id = mv.villain_id " +
                "JOIN minions m on m.id = mv.minion_id " +
                "WHERE v.id = ?;");
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(scanner.nextLine());
        statement.setInt(1, villainId);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            if (countMinions == 0){
                System.out.printf("Villain: %s%n", rs.getString("name"));
            }
            countMinions++;
            System.out.printf("%d. %s %d%n", countMinions, rs.getString("minion_name"), rs.getInt("age"));
        }
        if (countMinions == 0){
            System.out.printf("No villain with ID %d exists in the database.", villainId);
        }
    }
}