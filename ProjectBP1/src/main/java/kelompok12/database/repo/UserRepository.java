package kelompok12.database.repo;

import kelompok12.database.lib.DatabaseUtil;
import kelompok12.database.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String TABLE_NAME = "User";

    public boolean create(User user) {
        String query = "INSERT INTO " + TABLE_NAME + " (id, username, password, jk, alamat) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            String uniqueId = generateUniqueId(connection);
            user.setId(uniqueId);
            stmt.setString(1, uniqueId);
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getJenisKelamin());
            stmt.setString(5, user.getAlamat());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String generateUniqueId(Connection connection) throws SQLException {
        String uniqueId;
        boolean isUnique;
        do {
            uniqueId = java.util.UUID.randomUUID().toString();
            String query = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, uniqueId);
                try (ResultSet rs = stmt.executeQuery()) {
                    rs.next();
                    isUnique = rs.getInt(1) == 0;
                }
            }
        } while (!isUnique);
        return uniqueId;
    }

    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        try (Connection connection = DatabaseUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setJenisKelamin(rs.getString("jenisKelamin"));
                user.setAlamat(rs.getString("alamat"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean update(User user) {
        String query = "UPDATE " + TABLE_NAME + " SET username = ?, password = ?, jenisKelamin = ?, alamat = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getJenisKelamin());
            stmt.setString(4, user.getAlamat());
            stmt.setString(5, user.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String username, String password) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
