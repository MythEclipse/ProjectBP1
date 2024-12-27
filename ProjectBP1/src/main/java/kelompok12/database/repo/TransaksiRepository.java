/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelompok12.database.repo;

/**
 *
 * @author asephs
 */
import kelompok12.database.lib.DatabaseUtil;
import kelompok12.database.model.TransaksiModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiRepository {
    private static final String TABLE_NAME = "Transaksi";

    public boolean create(TransaksiModel transaksi) {
        String query = "INSERT INTO " + TABLE_NAME
                + " (id, username, type, penggunaan, saldoAwal, saldoAkhir) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, transaksi.getId());
            stmt.setString(2, transaksi.getUsername());
            stmt.setString(3, transaksi.getType());
            stmt.setLong(4, transaksi.getPenggunaan());
            stmt.setLong(5, transaksi.getSaldoAwal());
            stmt.setLong(6, transaksi.getSaldoAkhir());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TransaksiModel> readAll() {
        List<TransaksiModel> transaksis = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        try (Connection connection = DatabaseUtil.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                TransaksiModel transaksi = new TransaksiModel();
                transaksi.setId(rs.getString("id"));
                transaksi.setUsername(rs.getString("username"));
                transaksi.setType(rs.getString("type"));
                transaksi.setPenggunaan(rs.getLong("penggunaan"));
                transaksi.setSaldoAwal(rs.getLong("saldoAwal"));
                transaksi.setSaldoAkhir(rs.getLong("saldoAkhir"));
                transaksi.setDate(rs.getTimestamp("date"));
                transaksis.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaksis;
    }

    public boolean update(TransaksiModel transaksi) {
        String query = "UPDATE " + TABLE_NAME
                + " SET username = ?, type = ?, penggunaan = ?, saldoAwal = ?, saldoAkhir = ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, transaksi.getUsername());
            stmt.setString(2, transaksi.getType());
            stmt.setLong(3, transaksi.getPenggunaan());
            stmt.setLong(4, transaksi.getSaldoAwal());
            stmt.setLong(5, transaksi.getSaldoAkhir());
            stmt.setString(6, transaksi.getId());
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

    public List<TransaksiModel> findByUsername(String username) {
        List<TransaksiModel> transaksis = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TransaksiModel transaksi = new TransaksiModel();
                    transaksi.setId(rs.getString("id"));
                    transaksi.setUsername(rs.getString("username"));
                    transaksi.setType(rs.getString("type"));
                    transaksi.setPenggunaan(rs.getLong("penggunaan"));
                    transaksi.setSaldoAwal(rs.getLong("saldoAwal"));
                    transaksi.setSaldoAkhir(rs.getLong("saldoAkhir"));
                    transaksi.setDate(rs.getTimestamp("date"));
                    transaksis.add(transaksi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaksis;
    }
}
