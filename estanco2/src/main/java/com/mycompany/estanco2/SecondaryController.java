package com.mycompany.estanco2;

import com.mycompany.estanco2.dao.TabacoDAO;
import com.mycompany.estanco2.modelos.Tabaco;
import com.mycompany.estanco2.modelos.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;




public class SecondaryController { 
    
    
    
    private static TabacoDAO tbcdao;
    private Tabaco tbcseleccion;
    
    @FXML
    private TextField txtIdTabaco;

    @FXML
    private TextField txtIDSabor;

    @FXML
    private TextField txtGramos;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtUnidades;

    @FXML
    private ListView listTabacos;

    @FXML
    private Button btnAniadir;

    @FXML
    private Button btnModificar;

    @FXML
    private TextField txtIDMarca;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button btncerrarsesion;
    
    @FXML
    private Button btnsalirApp;
    
    
    
        /**
         * conexion a la base de datos
         * @throws IOException 
         */
    
    private static void conectarDB() throws IOException{
       tbcdao  = new TabacoDAO();
       try{
           tbcdao.conectar();
       }catch(SQLException e){
           AlertsUtil.mostrarError("Error de conexion a la base de datos" + e.getMessage());
           
       }catch(ClassNotFoundException e){
           AlertsUtil.mostrarError("Error al iniciar la aplicacion");
       }catch(IOException e){
           AlertsUtil.mostrarError("Error al cargar la configuracion");
       }
    }
    
    /**
     * METODO PARA EL BOTON AÑADIR TABACO
     */
    @FXML
   public void aniadir()  {
          try{
        tbcdao.aniadirTabaco (new Tabaco(Integer.parseInt(txtIdTabaco.getText()),
                Integer.parseInt(txtIDMarca.getText()),Integer.parseInt(txtIDSabor.getText()),
                Integer.parseInt(txtGramos.getText()),Integer.parseInt(txtPrecio.getText()),
                Integer.parseInt(txtUnidades.getText())));
        inicializarTabacos();
        Alert confirmacion= new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Añadir Tabaco");
        confirmacion.setContentText("¿Vas a añadir un tabaco, desea hacerlo?");
    }catch (SQLException ex){
        AlertsUtil.mostrarError("ERROR AL AÑADIR TABACO A LA BASE DE DATOS"+ex.getMessage());
    } 
               
               }
   /**
    * METODO PARA ELIMINAR TABACO
    */
    @FXML
    public void Eliminar()  {
       tbcseleccion=(Tabaco)listTabacos.getSelectionModel().getSelectedItem();
    if(tbcseleccion==null){
        AlertsUtil.mostrarError("No se ha seleccionado ningún campo de tabaco");
        return;
    }
    try{
        Alert confirmacion= new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Eliminar tabaco definitibamente");
        confirmacion.setContentText("¿Está seguro que desea borrar este tabaco?");
        Optional<ButtonType>respuesta=confirmacion.showAndWait();
        if(respuesta.get().getButtonData()==ButtonBar.ButtonData.CANCEL_CLOSE)
            return;
        tbcdao.eliminarTabaco(tbcseleccion);
        inicializarTabacos();
    }catch(SQLException ex){
        AlertsUtil.mostrarError("¡ERROR AL ELIMINAR EL TABACO SELECCIONADO!");
    }
    }
    
    /**
     * METODO PARA MODIFICAR TABACO
     */
    @FXML
   public void modificar() {
    tbcseleccion=(Tabaco)listTabacos.getSelectionModel().getSelectedItem();
    if(tbcseleccion==null){
        AlertsUtil.mostrarError("NO SE HA SELECCIONADO NINGUN TABACO");
        
    }
    try{
        tbcdao.actualizarTabaco(new Tabaco(Integer.parseInt(txtIdTabaco.getText()),
                Integer.parseInt(txtIDMarca.getText()),Integer.parseInt(txtIDSabor.getText()),
                Integer.parseInt(txtGramos.getText()),Integer.parseInt(txtPrecio.getText()),
                Integer.parseInt(txtUnidades.getText())));
        inicializarTabacos();
    }catch(SQLException ex){
        AlertsUtil.mostrarError("ERROR AL MODIFICAR EL TABACO"+ex.getMessage());
    } 
    }

    /**
     * METODO PARA INICIALIZAR LA LISTA DE TABACOS
     */
    public void inicializarTabacos() {
        listTabacos.getItems().clear();
        try{
            conectarDB();
            List<Tabaco> tabacos=tbcdao.listTabacos();
            listTabacos.setItems(FXCollections.observableList(tabacos));
        }catch(SQLException e){
            AlertsUtil.mostrarError("Error al cargar datos");
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @param tabacos.METODO PARA CARGAR TABACOS EN EL LISTVIEW 
     */
    public void cargarTabacos(Tabaco tabacos){
    
       txtIdTabaco.setText(Integer.toString(tabacos.getIdTabacosdecachimba()));
       txtIDMarca.setText(Integer.toString(tabacos.getIdMarca()));
       txtIDSabor.setText(Integer.toString(tabacos.getIdSabor()));
       txtGramos.setText(Integer.toString(tabacos.getGramos()));
       txtPrecio.setText(Integer.toString(tabacos.getPrecio()));
       txtUnidades.setText(Integer.toString(tabacos.getUnidades()));
    
   
}
    /**
     * 
     * @param event .METODO PARA SELECCIONAR TABACO CON EL RATON
     */
  public void seleciconarTabaco(Event event){
      tbcseleccion=(Tabaco)listTabacos.getSelectionModel().getSelectedItem();
      cargarTabacos(tbcseleccion);
  }  
    
    /**
     * METODO PARA SALIR DE LA APLICACION
     */
       @FXML
    public void salirApp() {
        System.exit(0);
    }
    
    /**
     * METODO PARA PASAR A LA PRIMERA INTERFAZ
     */
    @FXML
   public void cerrarSesion()  {
        try {
            App.setLogin("primary");
        } catch (IOException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
}


   
