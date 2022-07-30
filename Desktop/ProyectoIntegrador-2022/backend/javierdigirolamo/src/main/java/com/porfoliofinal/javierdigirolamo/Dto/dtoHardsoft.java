/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfoliofinal.javierdigirolamo.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHardsoft {
    @NotBlank
    private String nombreH;
    @NotBlank
    private String descripcionH;

    public dtoHardsoft() {
    }

    public dtoHardsoft(String nombreH, String descripcionH) {
        this.nombreH = nombreH;
        this.descripcionH = descripcionH;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public String getDescripcionH() {
        return descripcionH;
    }

    public void setDescripcionH(String descripcionH) {
        this.descripcionH = descripcionH;
    }
    
    
    
}
