/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfoliofinal.javierdigirolamo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSobremi {
    @NotBlank
    private String nombreS;
    @NotBlank
    private String descripcionS;

    public dtoSobremi() {
    }

    public dtoSobremi(String nombreS, String descripcionS) {
        this.nombreS = nombreS;
        this.descripcionS = descripcionS;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getDescripcionS() {
        return descripcionS;
    }

    public void setDescripcionS(String descripcionS) {
        this.descripcionS = descripcionS;
    }
    
    
    
}

