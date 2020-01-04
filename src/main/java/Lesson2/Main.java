package Lesson2;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBProcessor processor = null;
        try {
            DBConnector.connect();

            processor = new DBProcessor(DBConnector.getConnection());

            processor.createTable();

            processor.addUser("Ivanov", Sex.MALE, 32);
            processor.addUser("Petrov", Sex.MALE, 40);
            processor.addUser("Egorova", Sex.FEMALE, 25);

            processor.fetchUserList();

            processor.updateUser(3, "Ivanova", 26);

            processor.deleteUser(2);

            processor.fetchUserList();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            processor.releaseResources();
            DBConnector.disconnect();
        }
    }
}
