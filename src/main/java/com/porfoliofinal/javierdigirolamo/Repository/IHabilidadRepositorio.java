/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfoliofinal.javierdigirolamo.Repository;

import com.porfoliofinal.javierdigirolamo.Entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IHabilidadRepositorio extends JpaRepository<Habilidad, Integer>{
    public Optional<Habilidad> findByNombreHab(String nombreHab);
    public boolean existsByNombreHab(String nombreHab);

    
}