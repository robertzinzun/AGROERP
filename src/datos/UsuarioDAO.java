/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author roberto
 */
public class UsuarioDAO {
    public boolean validar(Usuario u){
        String sql="select e.nombre,u.estatus from empleados e join usuarios u \n" +
                   "on e.idempleado=u.idempleado\n" +
                   "where u.nombre=? and u.clave=? and u.estatus='A'";
        boolean ban=false;
        try{
            PreparedStatement ps=ConexionBD.getCn().prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getClave());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                u.setNombreCompleto(rs.getString(1));
                u.setEstatus(rs.getString(2));
                ban=true;
            }
            rs.close();
            ps.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error:"+ e.getMessage());
        }
        return ban;
    }
}
