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
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHab;
    private String valorHab;

    public Habilidad() {
    }

    public Habilidad(String nombreHab, String valorHab) {
        this.nombreHab = nombreHab;
        this.valorHab = valorHab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
