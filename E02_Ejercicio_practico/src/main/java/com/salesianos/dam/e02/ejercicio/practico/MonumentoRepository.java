package com.salesianos.dam.e02.ejercicio.practico;

import org.springframework.data.jpa.repository.JpaRepository;

//Se debe poner el tipo de la clase y el tipo del id de esa clase
public interface MonumentoRepository extends JpaRepository<Monumento, Long> {


}