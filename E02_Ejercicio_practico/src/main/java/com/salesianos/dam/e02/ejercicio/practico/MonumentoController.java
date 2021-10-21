package com.salesianos.dam.e02.ejercicio.practico;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController // Equivalente a @Controller + @ResponseBody
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository repository;

    //si pongo el tipo de la clase que he creado el codigo de respuesta siempre sera 200, si no quiero que
    //el codigo sea ese tengo que usar ResponseEntity.
    //ResponseEntity sirve para modificar el codigo de respuesta de http.
    @PostMapping("/")
    public ResponseEntity<Monumento> create (@RequestBody Monumento monumento) {

        //return ResponseEntity.status(201).body(repository.save(monumento));
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(monumento));
    }

    //@GetMapping("/")
    //public List<Monumento> findAll() {
    //  return repository.findAll();
    //}

    @GetMapping("/")
    public ResponseEntity<List<Monumento>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")

    //public Monumento findOne(@PathVariable("id") Long id){ return repository.findById(id).orElse(null); }
    public ResponseEntity<Monumento> findOne(@PathVariable Long id){
        return ResponseEntity.of(repository.findById(id)); }


    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(@RequestBody Monumento monumento, @PathVariable Long id) {
        return ResponseEntity.of(
            repository.findById(id).map(m1 -> {
            m1.setCodigoPais(monumento.getCodigoPais());
            m1.setNombrePais(monumento.getNombrePais());
            m1.setNombreCiudad(monumento.getNombreCiudad());
            m1.setLocalizacion(monumento.getLocalizacion());
            m1.setNombreMonumento(monumento.getNombreMonumento());
            m1.setDescripcion(monumento.getDescripcion());
            m1.setUrlFoto(monumento.getUrlFoto());
            repository.save(m1);
            return m1;
        })
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
