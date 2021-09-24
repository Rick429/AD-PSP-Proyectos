package com.salesianos.dam.E02_Ejercicio_practico;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Equivalente a @Controller + @ResponseBody
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository repository;

    @GetMapping("/")
    public List<Monumento> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Monumento findOne(@PathVariable("id") Long id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public ResponseEntity<Monumento> create (@RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(monumento));
    }
    @PutMapping("/{id}")
    public Monumento edit(@RequestBody Monumento monumento, @PathVariable Long id) {
        Monumento m1 = repository.findById(id).orElse(monumento);
        m1.setCodigoPais(monumento.getCodigoPais());
        m1.setNombrePais(monumento.getNombrePais());
        m1.setNombreCiudad(monumento.getNombreCiudad());
        m1.setLocalizacion(monumento.getLocalizacion());
        m1.setNombreMonumento(monumento.getNombreMonumento());
        m1.setDescripcion(monumento.getDescripcion());
        m1.setUrlFoto(m1.getUrlFoto());
        return repository.save(m1);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
