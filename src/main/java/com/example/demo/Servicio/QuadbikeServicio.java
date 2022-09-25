/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Quadbike;
import com.example.demo.Repositorio.QuadbikeRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eric2
 */
@Service
public class QuadbikeServicio {

    @Autowired
    private QuadbikeRepositorio quadbikeRepositorio;

    public List<Quadbike> getAll() {
        return quadbikeRepositorio.getAll();
    }

    public Optional<Quadbike> getQuadbike(int quadbikeId) {
        return quadbikeRepositorio.getQuadbike(quadbikeId);
    }

    public Quadbike save(Quadbike quadbike) {
        if (quadbike.getId() == null) {
            return quadbikeRepositorio.save(quadbike);
        } else {
            Optional<Quadbike> quadbike1 = quadbikeRepositorio.getQuadbike(quadbike.getId());
            if (quadbike1.isEmpty()) {
                return quadbikeRepositorio.save(quadbike);
            } else {
                return quadbike;
            }
        }
    }
}
