package com.salesianos.dam.E02_Ejercicio_practico;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class InitData {

    private final MonumentoRepository repository;

    public InitData(MonumentoRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        repository.saveAll(
                Arrays.asList(
                        new Monumento(34, "España", "Sevilla", 41.3758,"Christopher Columbus Monument", "Monumento de Sevilla","url"),
                        new Monumento(34, "España", "Sevilla", 37.380,"Glorieta de Bécquer", "Monumento de Sevilla","url"),
                        new Monumento(34, "España", "Barcelona", 41.4036,"La Sagrada Familia", "Monumento de Barcelona","url")
                )

        );

    }


}
