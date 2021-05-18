/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estanco2.modelos;


/**
 *ATRIBUTOS DE TABACO Y GETTER SETTER
 * @author david
 */

    
public class Tabaco {
    private int idTabacosdecachimba;
    private int idMarca;
    private int idSabor;
    private int gramos;
    private int precio;
    private int unidades;
    
    public Tabaco(){
    }


    
    public Tabaco(int idtabacosdecachimba,int idmarca,int idsabor,int gramos,int precio,int unidades){
        this.idTabacosdecachimba=idtabacosdecachimba;
        this.idMarca=idmarca;
        this.idSabor=idsabor;
        this.gramos=gramos;
        this.precio=precio;
        this.unidades=unidades;
    }

    public int getIdTabacosdecachimba() {
        return idTabacosdecachimba;
    }

    public void setIdTabacosdecachimba(int idTabacosdecachimba) {
        this.idTabacosdecachimba = idTabacosdecachimba;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(int idSabor) {
        this.idSabor = idSabor;
    }
    





    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Tabaco{" + "idTabacosdecachimba=" + idTabacosdecachimba + ", idMarca=" + idMarca + ", idSabor=" + idSabor + ", gramos=" + gramos + ", precio=" + precio + ", unidades=" + unidades + '}';
    }
       
    
}
