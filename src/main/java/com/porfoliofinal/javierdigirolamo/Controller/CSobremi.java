
package com.porfoliofinal.javierdigirolamo.Controller;

import com.porfoliofinal.javierdigirolamo.Dto.dtoSobremi;
import com.porfoliofinal.javierdigirolamo.Entity.Sobremi;
import com.porfoliofinal.javierdigirolamo.Security.Controller.Mensaje;
import com.porfoliofinal.javierdigirolamo.Service.SSobremi;
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
@RequestMapping("soblab")
@CrossOrigin(origins = "https://javierdigirolamofront.web.app")
public class CSobremi {
    @Autowired
    SSobremi sSobremi;  
    
    @GetMapping("/lista")
    public ResponseEntity<List<Sobremi>> list(){
        List<Sobremi> list = sSobremi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSobremi dtosob){
        if(StringUtils.isBlank(dtosob.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sSobremi.existsByNombreS(dtosob.getNombreS()))
            return new ResponseEntity(new Mensaje("Esa Experiencia Existe"), HttpStatus.BAD_REQUEST);
        
        Sobremi sobremi = new Sobremi(dtosob.getNombreS(), dtosob.getDescripcionS());
        sSobremi.save(sobremi);
        
        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSobremi dtosob){
        if(!sSobremi.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        if(sSobremi.existsByNombreS(dtosob.getNombreS()) && sSobremi.getByNombreS(dtosob.getNombreS()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Experiencia Ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtosob.getNombreS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Sobremi sobremi = sSobremi.getOne(id).get();
        sobremi.setNombreS(dtosob.getNombreS());
        sobremi.setDescripcionS((dtosob.getDescripcionS()));
        
        sSobremi.save(sobremi);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
         if(!sSobremi.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
         sSobremi.delete(id);
         
         return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Sobremi> getById(@PathVariable("id") int id){
        if(!sSobremi.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Sobremi sobremi = sSobremi.getOne(id).get();
        return new ResponseEntity(sobremi, HttpStatus.OK);
    }
}
 