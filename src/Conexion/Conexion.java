package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author albar
 */
public class Conexion {
    public static Connection con = null;
    public static Connection getConnection(){
        String url = "jdbc:postgresql://localhost:5432/AMS";
        String usuario = "postgres";
        String contraseña = "1234";
        try{
            Class.forName("org.postgresql.Driver");
            
        }catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"No se encontraron los Drivers" + e.getMessage(),
                    "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        try{
            con = DriverManager.getConnection(url, usuario, contraseña);
            
        }catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"ERROR" + e.getMessage(),
                    "error de conexion",JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
    
    public static ResultSet Consulta(String consulta){
        Connection con = getConnection();
        Statement declara;
        try {
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"ERROR" + e.getMessage(),
                    "error de conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public static Boolean Ejecutar(String consulta){
        boolean b = true;
        Connection con = getConnection();
        Statement declara;
        try {
            declara=con.createStatement();
            declara.executeQuery(consulta);
            return b;
        } catch (SQLException e) {
            b=false;
            System.out.print("Error: " + e);
        }
        return b;
    }
    
}
