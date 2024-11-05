package com.ceub.poo3.repository;

import com.ceub.poo3.enums.StatusEnum;
import com.ceub.poo3.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findAnimalByStatus(StatusEnum status);
}
