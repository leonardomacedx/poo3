package com.ceub.poo3.controller;

import com.ceub.poo3.dto.AnimalAtualizacaoDTO;
import com.ceub.poo3.dto.AnimalCadastroDTO;
import com.ceub.poo3.model.Animal;
import com.ceub.poo3.service.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {


    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Operation(summary = "Cadastro de animal. É necessário que todos os campos do JSON sejam preenchidos.")
    @PostMapping("/cadastro")
    public ResponseEntity<Animal> cadastroAnimal(@RequestBody @Valid AnimalCadastroDTO animalRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.cadastroAnimal(animalRequestDTO));
    }

    @Operation(summary = "Listagem de animais disponíveis.")
    @GetMapping("/animais")
    public ResponseEntity<List<Animal>> listarAnimais() {
        return ResponseEntity.ok().body(animalService.listarAnimais());
    }


    @Operation(summary = "Busca de animal por ID.")
    @GetMapping("/animais/{id}")
    public ResponseEntity<Animal> buscarAnimalPorId(@PathVariable int id) {
        return ResponseEntity.ok().body(animalService.buscarAnimalPorId(id));
    }

    @Operation(summary = "Atualização de animal por ID.")
    @PutMapping("/animais/{id}")
    public ResponseEntity<Animal> atualizarAnimalPorId(@PathVariable int id, @RequestBody AnimalAtualizacaoDTO animalRequest) {
        return ResponseEntity.ok().body(animalService.atualizarAnimalPorId(id, animalRequest));
    }

    @Operation(summary = "Remoção de animal por ID.")
    @DeleteMapping("/animais/{id}")
    public ResponseEntity<Void> deletarAnimalPorId(@PathVariable int id) {
        animalService.deletarAnimalPorId(id);
        return ResponseEntity.noContent().build();
    }
}
