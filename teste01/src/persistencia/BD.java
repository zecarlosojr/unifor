package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    private static final String URL = "jdbc:jtds:sqlserver://localhost:1433/cabuets";
    private static final String DRIVER = "net.sourceforge.jtds.jdbc.Driver";   
    private static final String USUARIO = "sa";   
    private static final String SENHA = "sa";   
	private static Connection conn;
    
    public static Connection getConn() {   
       try{   
           Class.forName( DRIVER );   
           conn = DriverManager.getConnection( URL, USUARIO, SENHA );  
       }   
       catch (ClassNotFoundException e ) {   
           e.getMessage();
           e.printStackTrace();
       } catch (SQLException e) {
    	   e.getMessage();
    	   e.printStackTrace();
       }
	return conn;   
    }
    
    public static void closeCon(){   
           try {
			conn.close();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
    }  
}

