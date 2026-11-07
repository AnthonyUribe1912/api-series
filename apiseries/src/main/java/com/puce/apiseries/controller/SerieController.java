package com.puce.apiseries.controller;

import com.puce.apiseries.models.Serie;
import com.puce.apiseries.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public ResponseEntity<List<Serie>> obtenerTodas() {
        List<Serie> series = serieService.obtenerTodas();
        return ResponseEntity.ok(series);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> obtenerPorId(@PathVariable Long id) {
        return serieService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Serie> crearSerie(@RequestBody Serie serie) {
        Serie nuevaSerie = serieService.guardar(serie);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSerie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> actualizarSerie(@PathVariable Long id, @RequestBody Serie serie) {
        return serieService.actualizar(id, serie)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSerie(@PathVariable Long id) {
        if (serieService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}