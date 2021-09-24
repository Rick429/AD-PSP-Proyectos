package com.salesianos.dam.E02_Ejercicio_practico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;
    private int codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private double localizacion;
    private String nombreMonumento;
    private String descripcion;
    private String urlFoto;


    public Monumento(int codigoPais, String nombrePais, String nombreCiudad, double localizacion, String nombreMonumento, String descripcion, String urlFoto) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.nombreCiudad = nombreCiudad;
        this.localizacion = localizacion;
        this.nombreMonumento = nombreMonumento;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
    }
}
