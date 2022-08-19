/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfoliofinal.javierdigirolamo.Service;

import com.ivanwportfolio.arprog.Entidad.Proyecto;
import com.ivanwportfolio.arprog.Repositorio.IProyectoRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoServicio {
    @Autowired
    IProyectoRepositorio iProyectoRepositorio;
    
    public List<Proyecto> list(){
        return iProyectoRepositorio.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return iProyectoRepositorio.findById(id);
    }
    
    public Optional<Proyecto> getByNombreProy(String nombreProy){
        return iProyectoRepositorio.findByNombreProy(nombreProy);
    }
    
    public void save(Proyecto proy){
        iProyectoRepositorio.save(proy);
    }
    
    public void delete(int id){
        iProyectoRepositorio.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProyectoRepositorio.existsById(id);
    }
    
    public boolean existsByNombreProy(String nombreProy){
        return iProyectoRepositorio.existsByNombreProy(nombreProy);
    }
}    
