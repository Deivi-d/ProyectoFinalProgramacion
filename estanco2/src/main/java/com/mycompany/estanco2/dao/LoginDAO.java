/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estanco2.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

/**
 *
 * @author david
 *
 */
public class LoginDAO {
    
    @FXML
    private ImageView imgLogo;
    @FXML
    private ImageView imgPass;
    @FXML
    private ImageView imgUser;
    
    private Connection conexion;
    
/**
 * METODO CONECTAR A LA BASE DE DATOS
 * @throws ClassNotFoundException
 * @throws SQLException
 * @throws IOException 
 */
    public void conectar() throws ClassNotFoundException, SQLException, IOException {
     
        String host = "localhost";
        String port = "3306";
        String name = "estanco2";
        String username = "root";
        String password ="2609060799";

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
    /**
     * METODO DESCONECTAR LA BASE DE DATOS
     * @throws SQLException 
     */
    public void desconectar() throws SQLException {
        conexion.close();
    }
    /**
     * 
     * @param nombre. METODO PARA BUSCAR NOMBRE
     * @param pass. METODO PARA BUSCAR PASSWORD
     * @return
     * @throws SQLException 
     */
    
    public boolean searchUsuario(String nombre,String pass) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE userName=? and password=? LIMIT 1";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombre);
        sentencia.setString(2, pass);
        ResultSet resultado = sentencia.executeQuery();

        return resultado.next();
    }
    

    
}
