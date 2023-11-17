package br.com.dianome.entregadores.controllers;

import br.com.dianome.entregadores.dtos.EntregadorDTO;
import br.com.dianome.entregadores.models.EntregadorModel;
import br.com.dianome.entregadores.repository.EntregadoresRepository;

import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EntregadorController {

    @Autowired
    EntregadoresRepository entregadoresRepository;

    @GetMapping("/entregadores")
    public ResponseEntity<List<EntregadorModel>> list(){
        List<EntregadorModel> entregadoresList = entregadoresRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(entregadoresList);
    }

    @PostMapping("/entregadores")
    public ResponseEntity<EntregadorModel> save(@RequestBody @Valid EntregadorDTO entregadorDTO) {
        var entregadoresModel = new EntregadorModel();
        BeanUtils.copyProperties(entregadorDTO, entregadoresModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(entregadoresRepository.save(entregadoresModel));
    }

    @GetMapping("/entregadores/{id}")
    public ResponseEntity<Object> detailById(@PathVariable(value = "id") Integer id){
        Optional<EntregadorModel> entregadores = entregadoresRepository.findById(id);
        if(entregadores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado na lista");
        }
        return ResponseEntity.status(HttpStatus.OK).body(((Optional<?>) entregadores).get());
    }

    @PutMapping("/entregadores/{id}")
    public ResponseEntity<Object> updateEntregador (@PathVariable(value="id") Integer id,
                                                     @RequestBody @Valid EntregadorDTO entregadorDTO) {
        Optional<EntregadorModel> entregador = entregadoresRepository.findById(id);
        if(entregador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado na lista");
        }
        var entregadoresModel = entregador.get();
        BeanUtils.copyProperties(entregadorDTO, entregadoresModel);
        return ResponseEntity.status(HttpStatus.OK).body(entregadoresRepository.save(entregadoresModel));
    }

    @DeleteMapping("/entregadores/{id}")
    public ResponseEntity<Object> deleteEntregador (@PathVariable(value = "id") Integer id){
        Optional<EntregadorModel> entregador = entregadoresRepository.findById(id);
        if(entregador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado na lista");
        }
        entregadoresRepository.delete(entregador.get());
        return ResponseEntity.status(HttpStatus.OK).body("O entregador foi excluído da lista");
    }
}
