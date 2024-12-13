/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelompok12.crud;

/**
 *
 * @author asephs
 */
import kelompok12.crud.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudRepository<T> {

    private final String tableName;

    public CrudRepository(String tableName) {
        this.tableName = tableName;
    }

    public boolean create(String columns, String values) {
        String query = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns, values);
        try (Connection connection = Koneksi.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<T> read(String condition) {
        List<T> result = new ArrayList<>();
        String query = String.format("SELECT * FROM %s WHERE %s", tableName, condition);
        try (Connection connection = Koneksi.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Assume T has a constructor that can handle ResultSet or use a factory method
                // result.add(T.valueOf(rs)); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(String setClause, String condition) {
        String query = String.format("UPDATE %s SET %s WHERE %s", tableName, setClause, condition);
        try (Connection connection = Koneksi.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String condition) {
        String query = String.format("DELETE FROM %s WHERE %s", tableName, condition);
        try (Connection connection = Koneksi.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

