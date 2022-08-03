
package com.porfoliofinal.javierdigirolamo.Controller;

import com.porfoliofinal.javierdigirolamo.Dto.dtoHardsoft;
import com.porfoliofinal.javierdigirolamo.Entity.Hardsoft;
import com.porfoliofinal.javierdigirolamo.Security.Controller.Mensaje;
import com.porfoliofinal.javierdigirolamo.Service.SHardsoft;
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
@RequestMapping("harlab")
@CrossOrigin(origins = "https://javierdigirolamofront.web.app")
public class CHardsoft {
    @Autowired
    SHardsoft sHardsoft;  
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hardsoft>> list(){
        List<Hardsoft> list = sHardsoft.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHardsoft dtohar){
        if(StringUtils.isBlank(dtohar.getNombreH()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sHardsoft.existsByNombreH(dtohar.getNombreH()))
            return new ResponseEntity(new Mensaje("Ese proyecto Existe"), HttpStatus.BAD_REQUEST);
        
        Hardsoft hardsoft = new Hardsoft(dtohar.getNombreH(), dtohar.getDescripcionH());
        sHardsoft.save(hardsoft);
        
        return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHardsoft dtohar){
        if(!sHardsoft.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        if(sHardsoft.existsByNombreH(dtohar.getNombreH()) && sHardsoft.getByNombreH(dtohar.getNombreH()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese Proyecto Ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtohar.getNombreH()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Hardsoft hardsoft = sHardsoft.getOne(id).get();
        hardsoft.setNombreH(dtohar.getNombreH());
        hardsoft.setDescripcionH((dtohar.getDescripcionH()));
        
        sHardsoft.save(hardsoft);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
         if(!sHardsoft.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
         sHardsoft.delete(id);
         
         return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hardsoft> getById(@PathVariable("id") int id){
        if(!sHardsoft.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Hardsoft hardsoft = sHardsoft.getOne(id).get();
        return new ResponseEntity(hardsoft, HttpStatus.OK);
    }
}