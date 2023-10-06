package com.developer.fishes.dao;

import com.developer.fishes.entity.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FishRepository extends JpaRepository<Fish, Integer> {
    List<Fish> findAllByOrderBySpecies();

    List<Fish> findAllByOrderByGenus();

    List<Fish> findAllByOrderByFamily();

    List<Fish> findAllByOrderByMaxLengthDesc();
}
