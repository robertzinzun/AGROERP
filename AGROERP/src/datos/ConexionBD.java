/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author roberto
 */
public class ConexionBD {
    private static Connection cn;
    private static String url="jdbc:oracle:thin:@10.211.55.3:1521:XE";
    private static String user="ERP";
    private static String pwd="ERP";
    private ConexionBD(){}
    public static Connection getCn(){
        if(cn==null){
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                cn=DriverManager.getConnection(url, user, pwd);
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error:"+e.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cn;
    }
    public static void cerrar(){
        if(cn!=null){
            try{
                cn.close();
                cn=null;
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error:"+e.getMessage());
            }
        }
    }
}
