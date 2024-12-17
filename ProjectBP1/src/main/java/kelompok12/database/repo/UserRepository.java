package kelompok12.database.repo;

import kelompok12.database.lib.DatabaseUtil;
import kelompok12.database.model.UserModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String TABLE_NAME = "User";

    public boolean create(UserModel user) {
        String query = "INSERT INTO " + TABLE_NAME + " (id, username, password, jk, alamat, uang) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            String uniqueId = generateUniqueId(connection);
            user.setId(uniqueId);
            stmt.setString(1, uniqueId);
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getJenisKelamin());
            stmt.setString(5, user.getAlamat());
            stmt.setLong(6, user.getUang());
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

    public List<UserModel> readAll() {
        List<UserModel> users = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        try (Connection connection = DatabaseUtil.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setJenisKelamin(rs.getString("jk"));
                user.setAlamat(rs.getString("alamat"));
                user.setUang(rs.getLong("uang"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean update(UserModel user) {
        String query = "UPDATE " + TABLE_NAME
                + " SET username = ?, password = ?, jk = ?, alamat = ?, uang = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getJenisKelamin());
            stmt.setString(4, user.getAlamat());
            stmt.setLong(5, user.getUang());
            stmt.setString(6, user.getId());
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

    public UserModel login(String username, String password) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new UserModel(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("jk"),
                        rs.getString("alamat"),
                        rs.getLong("uang"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
