/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfoliofinal.javierdigirolamo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreProy;
    private String detalleProy;
    private String enlaceProy;
    private String imagen;

    public Proyecto() {
    }

    public Proyecto(String nombreProy, String detalleProy, String enlaceProy, String imagen) {
        this.nombreProy = nombreProy;
        this.detalleProy = detalleProy;
        this.enlaceProy = enlaceProy;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public String getDetalleProy() {
        return detalleProy;
    }

    public void setDetalleProy(String detalleProy) {
        this.detalleProy = detalleProy;
    }

    public String getEnlaceProy() {
        return enlaceProy;
    }

    public void setEnlaceProy(String enlaceProy) {
        this.enlaceProy = enlaceProy;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


}
