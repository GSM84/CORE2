package Lesson2;

import java.sql.*;

public class DBProcessor {
    private static Connection        connection;
    private PreparedStatement prst;
    private Statement         stmt;

    public DBProcessor(Connection _connection) throws SQLException {
        this.connection = _connection;
        this.stmt = _connection.createStatement();
    }

    public void createTable() {
        try {
            int res = stmt.executeUpdate("create table users (" +
                    "id integer primary key autoincrement," +
                    "name text," +
                    "sex text," +
                    "age integer)");
        } catch (SQLException e) {
            System.out.println("Таблица уже существует.");
        }
    }

    public void addUser(String _name, Sex _sex, int _age) throws SQLException {
        prst = connection.prepareStatement("insert into users(name, sex, age) values(?, ?, ?)");

        prst.setString(1, _name);
        prst.setString(2, _sex.toString());
        prst.setInt(3, _age);

        prst.executeUpdate();
    }

    public void updateUser(int _id, String _name, int _age) throws SQLException {
        prst = connection.prepareStatement("update users set name = ?, age = ? where id = ?");

        prst.setString(1, _name);
        prst.setInt(2, _age);
        prst.setInt(3, _id);

        prst.executeUpdate();
    }

    public void fetchUserList() throws SQLException {
        ResultSet rs = stmt.executeQuery("select id, name, sex, age from users");
        System.out.println("User list");
        while (rs.next()){
            System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("sex") + " " +
                    rs.getInt("age")
            );
        }
    }

    public void deleteUser(int _id) throws SQLException {
        prst = connection.prepareStatement("delete from users where id = ?");

        prst.setInt(1, _id);
        prst.execute();
    }

    public void releaseResources(){
        try {
            stmt.close();
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
