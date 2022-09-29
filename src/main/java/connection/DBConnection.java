/** Paquete para hacer la conexión con la base de datos **/

package connection;

import java.sql.Connection;
import java.sql.DriverManager;




public class DBConnection {
    Connection  connection;
    static String db = "railway";
    static String  port = "6357";
    static String  login = "root";
    static String  password = "V4lvccrG1Usdnv66QxrN";
    static String ip = "containers-us-west-61.railway.app";

            
    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + DBConnection.port + "/" + DBConnection.db;
            connection = DriverManager.getConnection(url, this.login, this.password);
            System.out.println("Conexion Exitosa");
            
        } catch (Exception ex) {
            System.out.println("Error en la conecion " + ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }
 
}
