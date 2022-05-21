package Lesson7;

import java.sql.*;

public class AccuWeatherRepository {

    public AccuWeatherRepository() {
        createTable();
    }

    private Connection connect() throws SQLException {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite::memory:";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void createTable() {
        String createTable =
                "CREATE TABLE IF NOT EXISTS weather ("
                        + " id integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
                        + " city text NOT NULL,"
                        + " localDate date NOT NULL,"
                        + " dayPhrase text NULL,"
                        + " nightPhrase text NULL,"
                        + " minTemperature real NULL,"
                        + " maxTemperature real NULL"
                        + ");";

        try {
            Statement stmt = connect().createStatement();
            stmt.execute(createTable);
            connect().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(
            Weather weather) {
        String sql =
                "INSERT INTO weather(" +
                        " city," +
                        " localDate," +
                        " dayPhrase," +
                        " nightPhrase," +
                        " minTemperature," +
                        " maxTemperature" +
                        ") " +
                        "VALUES(?,?,?,?,?,?)";
        java.sql.Date sqlDate = new java.sql.Date(weather.date.getTime());
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, weather.cityName);
            pstmt.setDate(2, sqlDate);
            pstmt.setString(3, weather.dayPhrase);
            pstmt.setString(4, weather.nightPhrase);
            pstmt.setLong(5, weather.minTemperature);
            pstmt.setLong(6, weather.maxTemperature);
            pstmt.executeUpdate();
            connect().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
