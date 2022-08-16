/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfoliofinal.javierdigirolamo.Dto;

import javax.validation.constraints.NotBlank;


public class HabilidadDto {

    @NotBlank
    private String nombreHab;
    @NotBlank
    private String valorHab;

    public HabilidadDto() {
    }

    public HabilidadDto(String nombreHab, String valorHab) {
        this.nombreHab = nombreHab;
        this.valorHab = valorHab;
    }

    public String getNombreHab() {
        return nombreHab;
    }

    public void setNombreHab(String nombreHab) {
        this.nombreHab = nombreHab;
    }

    public String getValorHab() {
        return valorHab;
    }

    public void setValorHab(String valorHab) {
        this.valorHab = valorHab;
    }

}