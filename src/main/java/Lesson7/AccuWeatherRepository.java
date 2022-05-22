package Lesson7;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccuWeatherRepository {
    private String insertToWeather = "INSERT INTO weather(" +
            " city," +
            " localDate," +
            " dayPhrase," +
            " nightPhrase," +
            " minTemperature," +
            " maxTemperature" +
            ") " +
            "VALUES(?,?,?,?,?,?)";

    public AccuWeatherRepository() {
        createTable();
    }

    private Connection connect() throws SQLException {
        Connection conn = null;
        try {
            DriverManager.registerDriver(new JDBC());
            String url = "jdbc:sqlite:HomeWork8.db";
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
                        + " minTemperature integer NULL,"
                        + " maxTemperature integer NULL"
                        + ");";

        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(createTable);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(Weather weather) {
        java.sql.Date sqlDate = new java.sql.Date(weather.date.getTime());
        try {
            Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(insertToWeather);
            stmt.setString(1, weather.cityName);
            stmt.setDate(2, sqlDate);
            stmt.setString(3, weather.dayPhrase);
            stmt.setString(4, weather.nightPhrase);
            stmt.setInt(5, weather.minTemperature);
            stmt.setInt(6, weather.maxTemperature);
            stmt.executeUpdate();
            connect().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertBatch(List<Weather> weatherList) {
        try {
            Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(insertToWeather);
            for (Weather weather : weatherList) {
                java.sql.Date sqlDate = new java.sql.Date(weather.date.getTime());
                stmt.setString(1, weather.cityName);
                stmt.setDate(2, sqlDate);
                stmt.setString(3, weather.dayPhrase);
                stmt.setString(4, weather.nightPhrase);
                stmt.setInt(5, weather.minTemperature);
                stmt.setInt(6, weather.maxTemperature);
                stmt.addBatch();
            }
            stmt.executeBatch();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Weather> select(String cityName) {
        String sql = "SELECT * FROM weather WHERE city = ?";
        List<Weather> result = new ArrayList<>();
        try {
            Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cityName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Weather weather = new Weather(
                        rs.getString("city")
                        , new java.util.Date(rs.getDate("localDate").getTime())
                        , rs.getString("dayPhrase")
                        , rs.getString("nightPhrase")
                        , rs.getInt("minTemperature")
                        , rs.getInt("maxTemperature")
                );
                result.add(weather);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Weather> selectAll() {
        String sql = "SELECT * FROM weather";
        List<Weather> result = new ArrayList<>();
        try {
            Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Weather weather = new Weather(
                        rs.getString("city")
                        , new java.util.Date(rs.getDate("localDate").getTime())
                        , rs.getString("dayPhrase")
                        , rs.getString("nightPhrase")
                        , rs.getInt("minTemperature")
                        , rs.getInt("maxTemperature")
                );
                result.add(weather);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
