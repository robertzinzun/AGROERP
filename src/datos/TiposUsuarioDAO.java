/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author roberto
 */
public class TiposUsuarioDAO {
    private int paginas;
    public void cantPaginas(){
        String sql="select ceil(count(*)/10) paginas from tiposUsuario";
        try{
            Statement s=ConexionBD.getCn().createStatement();
            ResultSet rs=s.executeQuery(sql);
            if(rs.next()){
                paginas=rs.getInt("paginas");
            }
            rs.close();
            s.close();
        }
        catch(SQLException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    public ResultSet consultaGeneral(int pagina){
        String sql="select idTipoUsuario ID,NOMBRE from tiposUsuario where estatus='A'"
                + " where rownum>=? and rownum<=?";
        try{
            PreparedStatement s=ConexionBD.getCn().prepareStatement(sql);
            s.setInt(1, pagina*10-10);
            s.setInt(2, pagina*20);
            ResultSet rs=s.executeQuery(sql);
            return rs;
         
        }
        catch(SQLException e){
            System.out.println("Error:"+e.getMessage());
        }
        return null;
    }
}
