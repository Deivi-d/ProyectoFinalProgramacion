/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estanco2.modelos;

/**
 *ATRIBUTOS DE USUARIO Y GETTER SETTER
 * @author david
 */
public class Usuario {


    private int idUsuario;
    private String nombre;
    private String password;

    public Usuario(int i, String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return.devuelve una cadena de texto
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }



    public Usuario() {
    }
    
     /* public Usuario(int idUsuario,String nombre,String password) {
          this.idUsuario= idUsuario;
          this.nombre= nombre;
          this.password=password;
    }*/
    
        public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean checkNombre(String nombre){
        return nombre.length() >= 6;
    }
    
    /**
     * 
     * @param passw. metodo para validar contraseña
     * @return 
     */
    public boolean checkPassword(String passw){
        boolean ok = false;
        if (passw.matches(".*[A-Z].*") && passw.length() >=8) 
            ok = true;
        return ok;
    }


    
}
