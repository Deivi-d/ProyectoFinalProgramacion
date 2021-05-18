/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estanco2.modelos;

/**
 *ATRIBUTOS DE MARCA Y GETTERS SETTERS
 * @author david
 */
public class Marca {
        private int idMarca;
    private String nombreMarca;
    
    public Marca(){}
    
    public Marca(int id,String nombreMarca){
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setId(int idMarca) {
        this.idMarca= idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombre(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

}
