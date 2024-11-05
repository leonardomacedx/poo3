package com.ceub.poo3.service;

import com.ceub.poo3.dto.AnimalAtualizacaoDTO;
import com.ceub.poo3.dto.AnimalCadastroDTO;
import com.ceub.poo3.enums.StatusEnum;
import com.ceub.poo3.exception.AtualizacaoAnimalException;
import com.ceub.poo3.exception.CadastroAnimalException;
import com.ceub.poo3.exception.ExclusaoAnimalException;
import com.ceub.poo3.exception.ListarAnimalException;
import com.ceub.poo3.model.Animal;
import com.ceub.poo3.repository.AnimalRepository;
import com.ceub.poo3.util.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {


    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal cadastroAnimal(AnimalCadastroDTO animalRequestDTO) {
        Animal animal = new Animal();
        try {
            BeanUtils.copyProperties(animalRequestDTO, animal);
            animal.setStatus(StatusEnum.DISPONIVEL);
        } catch (Exception e) {
            throw new CadastroAnimalException("Erro ao cadastrar animal", e);
        } finally {
            animalRepository.save(animal);
        }
        return animal;
    }

    public List<Animal> listarAnimais() {
        return animalRepository.findAnimalByStatus(StatusEnum.DISPONIVEL);
    }

    public Animal buscarAnimalPorId(int id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isEmpty()) {
            throw new ListarAnimalException("Animal não encontrado");
        }
        return animal.get();
    }

    public Animal atualizarAnimalPorId(int id, AnimalAtualizacaoDTO animalRequest) {
        Animal animal = buscarAnimalPorId(id);
        try {
            BeanCopyUtils.copyNonNullProperties(animalRequest, animal);
            animal.setStatus(StatusEnum.valueOf(animalRequest.status()));
        } catch (Exception e) {
            throw new AtualizacaoAnimalException("Erro ao atualizar animal", e);
        } finally {
            animalRepository.save(animal);
        }
        return animal;
    }

    public void deletarAnimalPorId(int id) {
        try {
            Animal animal = buscarAnimalPorId(id);
            animalRepository.delete(animal);
        } catch (Exception e) {
            throw new ExclusaoAnimalException("Erro ao deletar animal", e);
        }
    }
}
