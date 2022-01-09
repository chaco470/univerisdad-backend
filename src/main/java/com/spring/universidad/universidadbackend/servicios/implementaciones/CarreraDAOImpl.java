package com.spring.universidad.universidadbackend.servicios.implementaciones;

import com.spring.universidad.universidadbackend.modelo.entidades.Carrera;
import com.spring.universidad.universidadbackend.repositorio.CarreraRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CarreraDAOImpl implements CarreraDAO {

    @Autowired
    private CarreraRepository repo;

    @Override
    @Transactional(readOnly = true)
    public Optional<Carrera> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    @Transactional
    public Carrera save(Carrera carrera) {
        return repo.save(carrera);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
