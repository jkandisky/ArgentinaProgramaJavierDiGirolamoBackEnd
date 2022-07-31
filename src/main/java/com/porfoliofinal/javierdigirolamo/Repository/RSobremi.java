
package com.porfoliofinal.javierdigirolamo.Repository;

import com.porfoliofinal.javierdigirolamo.Entity.Sobremi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RSobremi extends JpaRepository<Sobremi, Integer>{
    public Optional<Sobremi> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
    
    
}