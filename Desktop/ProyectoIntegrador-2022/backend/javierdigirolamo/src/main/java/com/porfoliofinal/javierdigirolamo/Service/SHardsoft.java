/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfoliofinal.javierdigirolamo.Service;

import com.porfoliofinal.javierdigirolamo.Entity.Hardsoft;
import com.porfoliofinal.javierdigirolamo.Repository.RHardsoft;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SHardsoft {
    @Autowired
    RHardsoft rHardsoft;  
    
    public List<Hardsoft> list(){
        return rHardsoft.findAll();
    }
    
    public Optional<Hardsoft> getOne(int id){
        return rHardsoft.findById(id);
    }
    
    public Optional<Hardsoft> getByNombreH (String nombreH){
        return rHardsoft.findByNombreH(nombreH);
    }
    
    public void save(Hardsoft hard){
        rHardsoft.save(hard);
    }
    
    public void delete(int id){
        rHardsoft.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHardsoft.existsById(id);
    }
    
    public boolean existsByNombreH(String nombreH){
        return rHardsoft.existsByNombreH(nombreH);
     }
}
