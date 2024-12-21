package l3.core;

import java.sql.*;

public interface DataBase {
    void getConnection() throws SQLException;
    void closeConnection() throws SQLException;
    ResultSet executeQuery(String sql) throws SQLException;
    void initPreparedStatenent(String sql) throws SQLException;
    int executeUpdate(String sql) throws SQLException;
    }
    
