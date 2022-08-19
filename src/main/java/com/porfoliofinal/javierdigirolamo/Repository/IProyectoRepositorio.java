/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfoliofinal.javierdigirolamo.Repository;

import com.porfoliofinal.javierdigirolamo.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProyectoRepositorio extends JpaRepository<Proyecto, Integer>{
    public Optional<Proyecto> findByNombreProy(String nombreProy);
    public boolean existsByNombreProy(String nombreProy);
}