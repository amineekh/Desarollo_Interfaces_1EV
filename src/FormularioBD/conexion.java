package FormularioBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    Connection conn;

    public conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //                                    "jdbc:mysql://localhost:3306/mydb"
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
        }catch (Exception e){
            System.err.println("No se pudo establecer conexion con la Base de Datos. Error "+e);
        }
    }

    public Connection getConnection() {return conn;}
}
