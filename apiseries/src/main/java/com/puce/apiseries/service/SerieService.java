package com.puce.apiseries.service;

import com.puce.apiseries.models.Serie;
import com.puce.apiseries.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    private final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public List<Serie> obtenerTodas() {
        return serieRepository.findAll();
    }

    public Optional<Serie> obtenerPorId(Long id) {
        return serieRepository.findById(id);
    }

    public Serie guardar(Serie serie) {
        return serieRepository.save(serie);
    }

    public Optional<Serie> actualizar(Long id, Serie serieDetalles) {
        return serieRepository.findById(id).map(serieExistente -> {
            serieExistente.setTitulo(serieDetalles.getTitulo());
            serieExistente.setPlataforma(serieDetalles.getPlataforma());
            serieExistente.setCalificacion(serieDetalles.getCalificacion());
            return serieRepository.save(serieExistente);
        });
    }

    public boolean eliminar(Long id) {
        if (serieRepository.existsById(id)) {
            serieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}