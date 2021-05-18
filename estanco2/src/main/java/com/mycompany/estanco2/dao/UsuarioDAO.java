/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estanco2.dao;

import com.mycompany.estanco2.App;
import com.mycompany.estanco2.modelos.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;



/**
 *
 * @author david
 */

//clase abstracta
public abstract class UsuarioDAO {
    
       private Connection conexion;
       /**
        * METODO PARA CONECTAR A LA BASE DE DATOS
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
     * METODO PARA DESCONECTAR LA BASE DE DATOS
     * @throws SQLException 
     */
    public void desconectar() throws SQLException {
        conexion.close();
    }
    
    /**
     * 
     * @param usuario.METODO PARA LOGUEARSE SELECCIONANDO LOS VALORES DE LA TABLA USUARIOS DE LA BASE DE DATOS
     * @return
     * @throws SQLException 
     */
    public boolean login(Usuario usuario) throws SQLException{

        String sql = "SELECT idusuarios,userName,password FROM usuarios WHERE userName = ?";
        
        PreparedStatement sentencia = conexion.prepareCall(sql);
        sentencia.setInt(1, usuario.getIdUsuario());
        sentencia.setString(2, usuario.getNombre());
        sentencia.setString(3,usuario.getPassword() );
        
        return false;
    }
    
    
}
