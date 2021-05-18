/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estanco2.modelos;

/**
 *ATRIBUTOS DE SABOR Y GETTERS SETTERS
 * @author david
 */
public class Sabor {

    private int idSabor;
    private String nombre_marca;       
    private String nombreSabor;
    
    public Sabor(){}
    
    public Sabor(int idSabor,String nombre_marca,String nombreSabor){
        
        this.idSabor=idSabor;
        this.nombre_marca=nombre_marca;
        this.nombreSabor=nombreSabor;
        
    }

    public int getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(int idSabor) {
        this.idSabor = idSabor;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public String getNombreSabor() {
        return nombreSabor;
    }

    public void setNombreSabor(String nombreSabor) {
        this.nombreSabor = nombreSabor;
    }



}


    
   


    
