package com.mycompany.conexionjdbc;
import java.sql.*;
import javax.swing.JOptionPane;
public class ConexionJDBC {
    
    
   
    private ConexionJDBC(){
        
    }
    
    
     /*
    Constructor privado que evita la instanciación 
    directa de la clase desde fuera de la misma.
    */
    
    
    //creamos una var en que guardaremos el estado de la conexion
    
    private static Connection conexion;
    
    //var que crea una sola instancia
    private static ConexionJDBC instancia;
    
    
    //var que conecta a la BD
    private static final String URL = "jdbc:mysql://localhost/sistema";
        private static final String USERNAME = "magnifico";
            private static final String PASSWORD = "magnifico";
            
    public Connection conectar(){
        try{
            //cargar el driver
            conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                   //JOptionPane.showMessageDialog(null,"CONEXION EXITOSA:" );
                   return conexion;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error :" + e);
            
        }
        return conexion;
    }
    
    //metodo cierre de conexion
// Método cierre de conexión
public void cerrarConexion() throws SQLException {
    try {
        conexion.close();
               //JOptionPane.showMessageDialog(null,"SE DESCONECTO DE LA BASE DE DATOS" );
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e);
    }
    finally{
        conexion.close();
    }
}

public static  ConexionJDBC getInstance(){
    if(instancia == null){
        instancia = new ConexionJDBC();
    }
    return instancia;
}
    
    


}
