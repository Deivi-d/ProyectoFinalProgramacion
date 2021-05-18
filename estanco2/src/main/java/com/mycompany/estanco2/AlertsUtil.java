/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estanco2;

import javafx.scene.control.Alert;

/**
 *
 * @author david
 * @param. Este metodo envia un mensaje de error al usuario.
 */

public class AlertsUtil {
        public static void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setContentText(mensaje);
        alerta.show();
    }
        /**
         * 
         * @param mensaje. Este metodo envia informacion para el usuario que use la aplicacion
         */
        public static void mostrarInformacion(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }
}
