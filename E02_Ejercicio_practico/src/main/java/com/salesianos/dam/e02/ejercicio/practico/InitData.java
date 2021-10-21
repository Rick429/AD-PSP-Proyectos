package com.salesianos.dam.e02.ejercicio.practico;

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
                        new Monumento("ES", "España", "Sevilla", "37.3834852,-5.9879042,15","Christopher Columbus Monument", "Monumento de Sevilla","url"),
                        new Monumento("ES", "España", "Sevilla", "37.3778617,-5.9891433,15","Glorieta de Bécquer", "Monumento de Sevilla","url"),
                        new Monumento("ES", "España", "Barcelona", "41.4036299,2.1743558,15","La Sagrada Familia", "Monumento de Barcelona","url")
                )

        );

    }


}
