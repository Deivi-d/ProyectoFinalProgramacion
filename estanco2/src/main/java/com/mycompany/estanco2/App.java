package com.mycompany.estanco2;

import com.mycompany.estanco2.modelos.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


/**
 * JavaFX App
 * Esta clase ejecuta la aplicacion llamando a diferentes metodos de otras clases
 * @author David
 */
public class App extends Application {

    private static Scene scene;
    private static Usuario user= new Usuario();

    
    /**
     * 
     * @param stage. Este parametro permite iniciar la primera escena de la aplicacion.
     * @throws IOException 
     */
    @Override
    public void start(Stage stage) throws IOException {
        String fxml="Primary";
        FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource(fxml+ ".fxml"));
        scene = new Scene(fxmlLoader.load(), 510, 300); //640, 480
        stage.setScene(scene);
        stage.show();
        // Give the controller access to the main app.
        PrimaryController controller= fxmlLoader.getController();
        controller.loadImage();
        
    }
    
    public static void loadSecondaryWindow() throws IOException, SQLException{
        String fxml="secondary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml +".fxml"));
        
        SecondaryController controller= new SecondaryController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.inicializarTabacos();
        
    }
    /**
     * 
     * @param u recibe el parametro de usuario
     */
    public static void setUsuario(Usuario u) {       
        user = u;

    }
    /**
     * 
     * @param fxml. Carga el archivo fxml.
     * @return
     * @throws IOException 
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    /**
     * 
     * @param fxml. Envia el metodo Login para usarse en otra clase.
     * @throws IOException 
     */
    public static void setLogin(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        
    }
    
    /**
     * 
     * @param args. Carga la aplicacion
     */
    public static void main(String[] args) {
        launch();
    }
    

}
