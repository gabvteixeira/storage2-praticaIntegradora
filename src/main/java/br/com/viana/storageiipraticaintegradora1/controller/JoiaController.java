package br.com.viana.storageiipraticaintegradora1.controller;

import br.com.viana.storageiipraticaintegradora1.model.Joia;
import br.com.viana.storageiipraticaintegradora1.service.IJoia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joias")
public class JoiaController {

    @Autowired
    private IJoia service;


    @GetMapping
    public ResponseEntity<List<Joia>> getJoias(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/inserir")
    public ResponseEntity<Joia> createJoia(@RequestBody Joia joia){
        Joia newJoia = this.service.create(joia);
        return new ResponseEntity<>(newJoia, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<Void> removeJoia(@RequestParam long joiaId){
        this.service.delete(joiaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Joia> updateJoia(@RequestParam long joiaId, @RequestBody Joia updateJoia){
        Joia updatedJoia = this.service.update(joiaId, updateJoia);
        return new ResponseEntity<>(updatedJoia, HttpStatus.OK);
    }

}
