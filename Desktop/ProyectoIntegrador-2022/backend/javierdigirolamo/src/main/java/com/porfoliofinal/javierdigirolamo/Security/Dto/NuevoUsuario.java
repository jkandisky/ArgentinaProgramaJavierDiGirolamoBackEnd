
package com.porfoliofinal.javierdigirolamo.Security.Dto;

import java.util.HashSet;
import java.util.Set;


public class NuevoUsuario {
    private String Nombre;
    private String nombreUsuario;
    private String Email;
    private String Password;
    private Set<String> roles = new HashSet<>();
     
    
    //Getters y Setters

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
    
}
