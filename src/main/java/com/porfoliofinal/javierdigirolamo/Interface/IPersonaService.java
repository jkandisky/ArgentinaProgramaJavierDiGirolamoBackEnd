
package com.porfoliofinal.javierdigirolamo.Interface;

import com.porfoliofinal.javierdigirolamo.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traer una lista de persona
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo persona
    public void  savePersona(Persona persona);
            
   //Eliminar un objeto
    public void deletePersona(Long id);
   
   //Buscar una persona
    public Persona findPersona(Long id);
   
}
