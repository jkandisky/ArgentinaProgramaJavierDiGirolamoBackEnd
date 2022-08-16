
package com.porfoliofinal.javierdigirolamo.Controller;

import com.porfoliofinal.javierdigirolamo.Dto.dtoAcercade;
import com.porfoliofinal.javierdigirolamo.Entity.Acercade;
import com.porfoliofinal.javierdigirolamo.Entity.Educacion;
import com.porfoliofinal.javierdigirolamo.Security.Controller.Mensaje;
import com.porfoliofinal.javierdigirolamo.Service.SAcercade;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acelab")
@CrossOrigin(origins = "https://javierdigirolamofront.web.app")
public class CAcercade {
    @Autowired
    SAcercade sAcercade;  
    
    @GetMapping("/lista")
    public ResponseEntity<List<Acercade>> list(){
        List<Acercade> list = sAcercade.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercade dtoace){
        if(StringUtils.isBlank(dtoace.getNombreA()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sAcercade.existsByNombreA(dtoace.getNombreA()))
            return new ResponseEntity(new Mensaje("Esa Experiencia Existe"), HttpStatus.BAD_REQUEST);
        
        Acercade acercade = new Acercade(dtoace.getNombreA(), dtoace.getDescripcionA());
        sAcercade.save(acercade);
        
        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercade dtoace){
        if(!sAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        if(sAcercade.existsByNombreA(dtoace.getNombreA()) && sAcercade.getByNombreA(dtoace.getNombreA()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Experiencia Ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoace.getNombreA()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Acercade acercade= sAcercade.getOne(id).get();
        acercade.setNombreA(dtoace.getNombreA());
        acercade.setDescripcionA((dtoace.getDescripcionA()));
        
        sAcercade.save(acercade);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
         if(!sAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
         sAcercade.delete(id);
         
         return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sAcercade.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Acercade acercade = sAcercade.getOne(id).get();
        return new ResponseEntity(acercade, HttpStatus.OK);
    }
}
 


