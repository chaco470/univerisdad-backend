package com.spring.universidad.universidadbackend.servicios.implementaciones;

import com.spring.universidad.universidadbackend.modelo.entidades.Aula;
import com.spring.universidad.universidadbackend.modelo.entidades.numeradores.TipoPizzarron;
import com.spring.universidad.universidadbackend.repositorio.AulaRepository;
import com.spring.universidad.universidadbackend.servicios.contratos.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AulaDAOImpl extends GenericDAOImpl<Aula, AulaRepository> implements AulaDAO {

    @Autowired
    public AulaDAOImpl(AulaRepository repo) {
        super(repo);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulaByTipoPizzarron(TipoPizzarron tipoPizzarron) {
        return repo.findAulaByTipoPizzarron(tipoPizzarron);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulaByPabellon_Nombre(String nombrePabellon) {
        return repo.findAulaByPabellon_Nombre(nombrePabellon);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulaByNumeroAula(Integer numeroAula) {
        return repo.findAulaByNumeroAula(numeroAula);
    }
}
