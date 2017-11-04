package com.ceeker.app.study.db;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ceeker
 * @create 2017/11/4 20:45
 **/
public class DbUtilTest {
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/elastic_job?user=root&password=root";


    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        String sql = "select * from job_execution_log";
        QueryRunner runner = new QueryRunner();
        List<Log> query = runner.query(connection, sql, new BeanListHandler<Log>(Log.class));
        System.out.println(query);
    }

    public static Connection getConnection() {
        DbUtils.loadDriver("com.jdbc.mysql.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
