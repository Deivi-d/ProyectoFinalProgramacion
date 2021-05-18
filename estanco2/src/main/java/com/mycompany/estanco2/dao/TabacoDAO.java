/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estanco2.dao;


import com.mycompany.estanco2.App;
import com.mycompany.estanco2.modelos.Tabaco;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author david
 */

public class TabacoDAO {
        private Connection conexion;
        /**
         * METODO PARA CONECTAR LA BASE DE DATOS A TRAVES DEL FICHERO
         * @throws ClassNotFoundException
         * @throws SQLException
         * @throws IOException 
         */
    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        
        Properties configuration = new Properties();
        configuration.load(new FileInputStream(new File(App.class.getResource("conexion2DB.properties").getPath())));
        String host = configuration.getProperty("host");
        String port = configuration.getProperty("port");
        String name = configuration.getProperty("name");
        String username = configuration.getProperty("username");
        String password = configuration.getProperty("password");

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
    /**
     * METODO PARA DESCONECTAR DE LA BASE DE DATOS
     * @throws SQLException 
     */
    public void desconectar() throws SQLException {
        conexion.close();
    }
    
    /**
     * 
     * @param tabaco.METODO PARA AÑADIR TABACOS CON PROCEDIMIENTO DE LA BASE DE DATOS
     * @throws SQLException 
     */
    public void aniadirTabaco(Tabaco tabaco) throws SQLException{
     String sql="{CALL spTabacoNuevo (?,?,?,?,?,?)}";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, tabaco.getIdTabacosdecachimba());
        sentencia.setInt(2, tabaco.getIdMarca());
        sentencia.setInt(3, tabaco.getIdSabor());
        sentencia.setInt(4, tabaco.getGramos());
        sentencia.setInt(5, tabaco.getPrecio());
        sentencia.setInt(6, tabaco.getUnidades());
        sentencia.executeUpdate();
    }
    
    /**
     * 
     * @param tabaco.METODO PARA ELIMINAR TABACO
     * @throws SQLException 
     */
    public void eliminarTabaco(Tabaco tabaco) throws SQLException{
        String sql = "DELETE  FROM tabacosdecachimba WHERE idTabacosdecachimba=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, tabaco.getIdTabacosdecachimba());
        sentencia.executeUpdate();
        
    }
    /**
     * 
     * @param tabaco.METODO PARA ACTUALIZAR TABACO CON PROCEDIMIENTO DE LA BASE DE DATOS
     * @throws SQLException 
     */
    public void actualizarTabaco(Tabaco tabaco) throws SQLException{
        String sql = "{CALL spActualizarTabaco(?,?,?,?,?,?)}";
        CallableStatement sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, tabaco.getIdTabacosdecachimba());
        sentencia.setInt(2, tabaco.getIdMarca());
        sentencia.setInt(3, tabaco.getIdSabor());
        sentencia.setInt(4, tabaco.getGramos());
        sentencia.setInt(5, tabaco.getPrecio());
        sentencia.setInt(6, tabaco.getUnidades());
        sentencia.execute();
    }
    /**
     * METODO PARA INICIALIZAR LA LISTA DE TABACOS
     * @return
     * @throws SQLException 
     */
    public List<Tabaco> listTabacos() throws SQLException{
        List<Tabaco> tabacos = new ArrayList<>();
        String sql = "SELECT * FROM tabacosdecachimba";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()){
            Tabaco tabaco = new Tabaco();
            
            tabaco.setIdTabacosdecachimba(resultado.getInt(1));
            tabaco.setIdMarca(resultado.getInt(2));
            tabaco.setIdSabor(resultado.getInt(3));
            tabaco.setGramos(resultado.getInt(4));
            tabaco.setPrecio(resultado.getInt(5));
            tabaco.setUnidades(resultado.getInt(6));
            tabacos.add(tabaco);
            

        }
        
        return tabacos;
    }
    /**
     * 
     * @param tabacos.METODO PARA SELECCIONAR LA TABLA TABACOSDECACHIMBA DE LA BASE DE DATOS
     * @throws SQLException 
     */
    public void seleccionarTabacos(Tabaco tabacos) throws SQLException{
     String sql ="SELECT * FROM tabacosdecachimba";
    }
    /**
     * 
     * @param idtabacosdecachimba.METODO PARA BUSCAR TABACO A PARTIR DE SU ID
     * @return
     * @throws SQLException 
     */
    public boolean buscarTabaco(int idtabacosdecachimba)throws SQLException{
        String sql = "SELECT * FROM tabacosdecachimba WHERE idTabacosdecachimba LIKE ? LIMIT 1";
        PreparedStatement sentencia=conexion.prepareStatement(sql);
        sentencia.setInt(1, idtabacosdecachimba);
        ResultSet resultado = sentencia.executeQuery();
        
        return resultado.next();
    }
}
