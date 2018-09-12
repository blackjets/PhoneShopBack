package shop;

import java.sql.*;

public class PhoneShop {
    /**
     * @param args
     */


    public static void main(String[] args) {
        genDB();
        try {
            sqlInsert();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


    }

    public static void genDB() {

        Statement stmt;
        try {
            Connection c = dbOpen();
//      Class.forName("org.postgresql.Driver");
//            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testbase", "postgres", "password");
//            c.setAutoCommit(false);
//            System.out.println("database opened successfully");\

            String sql;

            // Create database table
            stmt = c.createStatement();
            sql = "CREATE TABLE MOBILE" +
                    "(ID INT PRIMARY KEY    NOT NULL," +
                    "COMPANY_NAME   TEXT    NOT NULL," +
                    "MODEL  TEXT    NOT NULL," +
                    "COST   INT   NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            System.out.println("table create success");


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


    }

    private static Connection dbOpen() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testbase", "postgres", "password");
        c.setAutoCommit(false);
        System.out.println("database opened successfully");
        return c;
    }

    public static void sqlInsert() {
        Connection c;
        Statement stmt;
        try {
            c = dbOpen();
            String sql;

            stmt = c.createStatement();
            sql = "INSERT INTO MOBILE (ID,COMPANY_NAME,MODEL,COST) VALUES (1, 'Siemens', 'A35', 100)";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            System.out.println("insert success");


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public static void sqlSelect() {
        Connection c;
        Statement stmt;
        try {
            c = dbOpen();

            //select
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MOBILE");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("company_name") + " "
                        + rs.getString("model") + " " + rs.getInt("cost")
                );
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

}
