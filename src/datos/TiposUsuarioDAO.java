/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author roberto
 */
public class TiposUsuarioDAO {
    public ResultSet consultaGeneral(){
        String sql="select idTipoUsuario ID,NOMBRE from tiposUsuario where estatus='A'";
        try{
            Statement s=ConexionBD.getCn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=s.executeQuery(sql);
            return rs;
         
        }
        catch(SQLException e){
            System.out.println("Error:"+e.getMessage());
        }
        return null;
    }
}
