package com.mycompany.utils;

import io.github.cdimascio.dotenv.Dotenv;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    private static Dotenv dotenv = Dotenv.load(); // Tải biến môi trường từ file .env
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");

    private static HikariDataSource dataSource;

    static {
        // Cấu hình HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL + ";databaseName=sales_management_db;encrypt=false");
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10); // Số lượng kết nối tối đa trong pool
        config.setConnectionTimeout(30000); // Thời gian chờ kết nối (30 giây)
        config.setIdleTimeout(600000); // Thời gian kết nối không hoạt động (10 phút)
        config.setMaxLifetime(1800000); // Thời gian sống tối đa của kết nối (30 phút)

        dataSource = new HikariDataSource(config);
        LOGGER.info("ket noi duoc khoi tao!");
    }

    // Lấy kết nối từ pool
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Đóng dataSource khi ứng dụng kết thúc
    public static void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();
            LOGGER.info("Kết nối pool đã được đóng.");
        }
    }
