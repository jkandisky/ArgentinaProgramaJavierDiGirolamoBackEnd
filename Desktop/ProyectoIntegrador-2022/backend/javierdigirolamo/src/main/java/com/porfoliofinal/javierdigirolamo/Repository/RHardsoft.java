/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfoliofinal.javierdigirolamo.Repository;

import com.porfoliofinal.javierdigirolamo.Entity.Hardsoft;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHardsoft extends JpaRepository<Hardsoft, Integer>{
    public Optional<Hardsoft> findByNombreH(String nombreH);
    public boolean existsByNombreH(String nombreH);
    
    
}

