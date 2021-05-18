package com.mycompany.estanco2;


import com.mycompany.estanco2.dao.LoginDAO;
import com.mycompany.estanco2.modelos.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class PrimaryController {
    
  
    
    @FXML 
    private Label resultado;
    
    @FXML 
    private TextField user;
    
    @FXML 
    private PasswordField pass;
    
    @FXML
    private Button btnlogin;
    
    @FXML
    private ImageView imglogo;
    
    @FXML
    private ImageView imgPass;
    
    @FXML
    private ImageView imgUser;
    
    @FXML
    private Button btnSalir;
    
    
    /**
     * METODO PARA EL BOTON LOGIN PARA ACCEDER A LA SEGUNDA INTERFAZ
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @FXML 
    private void login() throws ClassNotFoundException, SQLException{
        
        LoginDAO miLogin= new LoginDAO();
        
        String Usuario=user.getText();
        String password=pass.getText();
        boolean ok=false;
        try {
            miLogin.conectar();
            
            ok=miLogin.searchUsuario(Usuario, password);
            if(ok){
                App.loadSecondaryWindow();
            }else{
                AlertsUtil.mostrarError("Usuario o contraseña erronea");
            } 
            
        } catch (IOException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        
    /**
     * METODO PARA CARGAR LAS IMAGENES DE LA PRIMERA INTERFAZ
     */
        public void loadImage(){
            Image img = new Image(getClass().getResourceAsStream("/images/logo.png"));
            imglogo.setImage(img);

            Image img2 = new Image(getClass().getResourceAsStream("/images/user.png"));
            imgUser.setImage(img2); 

            Image img3 = new Image(getClass().getResourceAsStream("/images/imgpass.png"));
            imgPass.setImage(img3);
        

    
        }
        
       
        /**
         * METODO PARA SALIR DE LA APLICACION
         */
        @FXML
        public void salir() {
            System.exit(0);
        }
}