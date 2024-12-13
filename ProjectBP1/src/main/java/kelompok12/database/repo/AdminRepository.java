/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelompok12.database.repo;

/**
 *
 * @author asephs
 */
import kelompok12.database.lib.CrudRepository;
import kelompok12.database.lib.DatabaseUtil;
import kelompok12.database.model.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository extends CrudRepository<Admin> {

    public AdminRepository() {
        super("Admin");
    }

    @Override
    public List<Admin> read(String condition) {
        List<Admin> admins = new ArrayList<>();
        String query = String.format("SELECT * FROM Admin WHERE %s", condition);
        try (Connection connection = DatabaseUtil.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public boolean login(String username, String password) {
        String query = "SELECT * FROM Admin WHERE username = ? AND password = ?";
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

