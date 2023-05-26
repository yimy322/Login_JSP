package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author yimy
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123456";
    
    private static BasicDataSource dataSource;
    
    public static DataSource getDataSource(){
        
        if (dataSource==null) {
            dataSource = new BasicDataSource();
            
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            
            dataSource.setInitialSize(50);
        }
        
        
        
        return dataSource;
        
    } 
    
    public static Connection getConnection() throws SQLException{
        
        return getDataSource().getConnection();
        
    }
    
    public static void close(ResultSet rs) throws SQLException{
        
        rs.close();
        
    }
    
    public static void close(Statement smtm) throws SQLException{
        
        smtm.close();
        
    }
    
    public static void close(PreparedStatement smtm) throws SQLException{
        
        smtm.close();
        
    }
    
    public static void close(Connection conn) throws SQLException{
        
        conn.close();
        
    }
    
}
