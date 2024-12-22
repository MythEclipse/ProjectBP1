package kelompok12.database.lib;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtil {

    private static HikariDataSource dataSource;

    static {
        try {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://217.15.165.147:3306/db_bank");
            config.setUsername("asephs");
            config.setPassword("hunterz");
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");

            // Optional: Tuning pool settings
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(2);
            config.setIdleTimeout(30000);
            config.setMaxLifetime(1800000);

            dataSource = new HikariDataSource(config);

            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.err.println("Koneksi Gagal: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            if (connection != null) {
                System.out.println("Koneksi berhasil digunakan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
