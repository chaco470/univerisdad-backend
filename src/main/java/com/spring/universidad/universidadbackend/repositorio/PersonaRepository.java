package com.spring.universidad.universidadbackend.repositorio;
import com.spring.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
