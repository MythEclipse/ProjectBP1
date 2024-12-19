package kelompok12.database.repo;

import kelompok12.database.lib.DatabaseUtil;
import kelompok12.database.model.TransaksiModel;
import kelompok12.database.model.UserModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String TABLE_NAME = "User";
    private List<UserModel> userCache = new ArrayList<>();
    private boolean isCacheLoaded = false;

    public boolean create(UserModel user) {
        String query = "INSERT INTO " + TABLE_NAME
                + " (id, username, password, jk, alamat, uang) VALUES (?, ?, ?, ?, ?, ?)";
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
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    public boolean updateByUsername(UserModel user) {
        StringBuilder queryBuilder = new StringBuilder("UPDATE " + TABLE_NAME + " SET ");
        List<Object> parameters = new ArrayList<>();

        if (user.getPassword() != null) {
            queryBuilder.append("password = ?, ");
            parameters.add(user.getPassword());
        }
        if (user.getJenisKelamin() != null) {
            queryBuilder.append("jk = ?, ");
            parameters.add(user.getJenisKelamin());
        }
        if (user.getAlamat() != null) {
            queryBuilder.append("alamat = ?, ");
            parameters.add(user.getAlamat());
        }

        // Remove the last comma and space
        queryBuilder.setLength(queryBuilder.length() - 2);
        queryBuilder.append(" WHERE username = ?");
        parameters.add(user.getUsername());

        String query = queryBuilder.toString();

        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateById(String id, String username, String password, String jenisKelamin, String alamat) {
        StringBuilder queryBuilder = new StringBuilder("UPDATE " + TABLE_NAME + " SET ");
        List<Object> parameters = new ArrayList<>();

        if (username != null) {
            queryBuilder.append("username = ?, ");
            parameters.add(username);
        }
        if (password != null) {
            queryBuilder.append("password = ?, ");
            parameters.add(password);
        }
        if (jenisKelamin != null) {
            queryBuilder.append("jk = ?, ");
            parameters.add(jenisKelamin);
        }
        if (alamat != null) {
            queryBuilder.append("alamat = ?, ");
            parameters.add(alamat);
        }

        // Remove the last comma and space
        queryBuilder.setLength(queryBuilder.length() - 2);
        queryBuilder.append(" WHERE id = ?");
        parameters.add(id);

        String query = queryBuilder.toString();

        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            if (stmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserModel login(String username, String password) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    UserModel user = new UserModel();
                    user.setId(rs.getString("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setJenisKelamin(rs.getString("jk"));
                    user.setAlamat(rs.getString("alamat"));
                    user.setUang(rs.getLong("uang"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean transfer(String fromUserId, String toUserId, long amount, String Username) {
        String withdrawQuery = "UPDATE " + TABLE_NAME + " SET uang = uang - ? WHERE id = ?";
        String depositQuery = "UPDATE " + TABLE_NAME + " SET uang = uang + ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement withdrawStmt = connection.prepareStatement(withdrawQuery);
                    PreparedStatement depositStmt = connection.prepareStatement(depositQuery)) {
                withdrawStmt.setLong(1, amount);
                withdrawStmt.setString(2, fromUserId);
                if (withdrawStmt.executeUpdate() == 0) {
                    connection.rollback();
                    return false;
                }

                depositStmt.setLong(1, amount);
                depositStmt.setString(2, toUserId);
                if (depositStmt.executeUpdate() == 0) {
                    connection.rollback();
                    return false;
                }

                // Record the transaction
                TransaksiModel transaksi = new TransaksiModel();
                transaksi.setId(fromUserId);
                transaksi.setUsername(Username);
                transaksi.setType("TRANSFER");
                transaksi.setPenggunaan(amount);
                transaksi.setSaldoAwal(getUserSaldo(fromUserId));
                transaksi.setSaldoAkhir(transaksi.getSaldoAwal() - amount);
                recordTransaction(connection, transaksi);

                connection.commit();
                return true;
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public long getUserSaldo(String userId) throws SQLException {
        String query = "SELECT uang FROM " + TABLE_NAME + " WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong("uang");
                }
            }
        }
        return 0;
    }

    private void recordTransaction(Connection connection, TransaksiModel transaksi) throws SQLException {
        String query = "INSERT INTO Transaksi (id, username, type, penggunaan, saldoAwal, saldoAkhir) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, transaksi.getId());
            stmt.setString(2, transaksi.getUsername());
            stmt.setString(3, transaksi.getType());
            stmt.setLong(4, transaksi.getPenggunaan());
            stmt.setLong(5, transaksi.getSaldoAwal());
            stmt.setLong(6, transaksi.getSaldoAkhir());
            stmt.executeUpdate();
        }
    }

    public boolean tarikUang(String userId, long amount, String Username) {
        String query = "UPDATE " + TABLE_NAME + " SET uang = uang - ? WHERE id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            stmt.setLong(1, amount);
            stmt.setString(2, userId);
            if (stmt.executeUpdate() > 0) {
                // Record the transaction
                TransaksiModel transaksi = new TransaksiModel();
                transaksi.setId(userId);
                transaksi.setUsername(Username);
                transaksi.setType("WITHDRAW");
                transaksi.setPenggunaan(amount);
                transaksi.setSaldoAwal(getUserSaldo(userId));
                transaksi.setSaldoAkhir(transaksi.getSaldoAwal() - amount);
                recordTransaction(connection, transaksi);

                connection.commit();
                return true;
            }
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<UserModel> findByUsername(String username) {
        if (!isCacheLoaded) {
            loadCache();
        }
        List<UserModel> users = new ArrayList<>();
        for (UserModel user : userCache) {
            if (user.getUsername().contains(username)) {
                users.add(user);
            }
        }
        return users;
    }

    private void loadCache() {
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
                userCache.add(user);
            }
            isCacheLoaded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
