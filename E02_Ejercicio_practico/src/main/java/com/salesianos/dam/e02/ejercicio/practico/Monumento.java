package com.salesianos.dam.e02.ejercicio.practico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;
    private String codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private String localizacion;
    private String nombreMonumento;

    //@Lob
    @Column(length= 1000)
    private String descripcion;
    private String urlFoto;


    public Monumento(String codigoPais, String nombrePais, String nombreCiudad, String localizacion, String nombreMonumento, String descripcion, String urlFoto) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.nombreCiudad = nombreCiudad;
        this.localizacion = localizacion;
        this.nombreMonumento = nombreMonumento;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
    }
}
