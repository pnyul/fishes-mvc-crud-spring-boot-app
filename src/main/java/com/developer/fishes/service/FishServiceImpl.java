package com.developer.fishes.service;

import com.developer.fishes.dao.FishRepository;
import com.developer.fishes.entity.Fish;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishServiceImpl implements FishService {

    private FishRepository fishRepository;

    //constructor injection, only one constructor -> @Autowired annotation isn't necessary
    public FishServiceImpl(FishRepository theFishRepository) {
        fishRepository = theFishRepository;
    }

    @Override
    public List<Fish> findAll() {
        return fishRepository.findAllByOrderByMaxLengthDesc();
    }

    @Override
    public Fish findById(int id) {

        //Optional can store "empty" value
        Optional<Fish> result = fishRepository.findById(id);

        Fish fish = null;

        if (result.isPresent()) {
            fish = result.get();
        } else {
            // if Fish object doesn't exist
            throw new RuntimeException("Can't find Fish id: " + id);
        }

        return fish;
    }

    @Override
    public void save(Fish fish) {
        fishRepository.save(fish);
    }

    @Override
    public void deleteById(int id) {
        fishRepository.deleteById(id);
    }

}