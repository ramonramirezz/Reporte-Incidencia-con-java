
package proyectofinal;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conexion {
       public Connection conectar() throws ClassNotFoundException {
        Connection con = null;
        try{
            //cargar la driver
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/projectdb","root","");
//        JOptionPane.showMessageDialog(null,"Conexion establecida");
        }catch ( SQLException e){
        JOptionPane.showMessageDialog(null,"Error al conectarse"+ e);
        }
        return con;
        }
}
