/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelompok12.database.repo;
/**
 *
 * @author asephs
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import kelompok12.database.lib.CrudRepository;
import kelompok12.database.lib.DatabaseUtil;
import kelompok12.database.model.User;

public class UserRepository extends CrudRepository<User> {

    public UserRepository() {
        super("User");
    }

    @Override
    public List<User> read(String condition) {
        List<User> users = new ArrayList<>();
        String query = String.format("SELECT * FROM User WHERE %s", condition);
        try (Connection connection = DatabaseUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean login(String username, String password) {
        String query = "SELECT * FROM User WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();  // Jika ada hasil, berarti login berhasil
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

