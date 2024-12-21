package l3.core;

import java.sql.*;

public class DataBaseImpl  implements DataBase{

protected final String URL = "jdbc:mysql://localhost:3306/gest_pret_boutiquier";
protected final String USER = "root";
protected final String PASSWORD= "";
protected PreparedStatement ps;
protected Connection conn = null;
@Override
public void getConnection() throws SQLException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection(URL,USER,PASSWORD);

    }catch (ClassNotFoundException e) {
        e.printStackTrace();
        ;

        }
       
       
}
@Override
public void closeConnection() throws SQLException {
   if (conn!=null && !conn.isClosed()) {
    conn.close();
   }
}
@Override
public ResultSet executeQuery(String sql) throws SQLException {
    this.initPreparedStatenent(sql);
    return ps.executeQuery();
}


@Override
public int executeUpdate(String sql) throws SQLException {
    this.initPreparedStatenent(sql);
    return ps.executeUpdate();
}
@Override
public void initPreparedStatenent(String sql) throws SQLException {
    ps = conn.prepareStatement(sql);
}
    
}
