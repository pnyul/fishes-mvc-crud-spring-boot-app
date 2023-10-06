package com.developer.fishes.service;

import com.developer.fishes.entity.Fish;

import java.util.List;

public interface FishService {

    List<Fish> findAll();

    void save(Fish fish);

    Fish findById(int id);

    void deleteById(int id);

}
