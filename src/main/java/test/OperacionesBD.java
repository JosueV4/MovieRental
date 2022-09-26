/** Acciones que se van a realizar dentro del aplicativo web **/
package test;

import beans.Pelicula;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesBD {
    
    public static void main(String[] args) {
        listarPelicula(); 

    }
    
    public static void actualizarPelicula(int id, String genero){
        DBConnection con = new DBConnection();
        
        String sql = "UPDATE pelicula SET genero = ' "+genero+" ' WHERE id = " + id;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {                                 /** Quiere decir que cuando desconecte termine el proceso **/
            con.desconectar(); 
        }
    }
    
    
        public static void listarPelicula(){       /** Metodo para listar todas las peliculas **/
        DBConnection con = new DBConnection();    /** DBConnection para conectarnos a la base de datos **/
        String sql = "SELECT * FROM pelicula";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);    /** Ejecuta la sentencia SQL select **/
            while (rs.next()){                                 /** next es un metodo que va a recorrer pelicula por pelicula **/
                int id = rs.getInt("id");                      /** Trae el valor que encuentre el id **/
                String titulo = rs.getString("titulo");     
                String genero = rs.getString("genero");                 
                String autor = rs.getString("autor"); 
                int copias = rs.getInt("copias");
                boolean novedad = rs.getBoolean("novedad");
                
                Pelicula pelicula = new Pelicula(id, titulo, genero, autor, copias, novedad);
                System.out.println(pelicula.toString());
            }
            st.executeQuery(sql);
            

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {                                 /** Quiere decir que cuando desconecte termine el proceso **/
            con.desconectar(); 
        }
    }
    
    
}
