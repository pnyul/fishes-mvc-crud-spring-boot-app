package com.developer.fishes.controller;

import com.developer.fishes.entity.Fish;
import com.developer.fishes.service.FishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fishes")
public class FishController {

    private FishService fishService;

    //constructor injection, only one constructor -> @Autowired annotation isn't necessary
    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    //mapping to "/list"
    @GetMapping("/list")
    public String listFishes(Model model) {

        //gets all Fish from the database and adds them to a List
        List<Fish> fishList = this.fishService.findAll();
        //add attribute to model
        model.addAttribute("fishes", fishList);

        return "fishes/list-fishes";
    }

    @PostMapping("/save")
    public String saveFish(@ModelAttribute("fish") Fish fish) {

        fishService.save(fish);

        return "redirect:/fishes/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("fishId") int id) {

        fishService.deleteById(id);

        return "redirect:/fishes/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Fish fish = new Fish();
        //Spring model -> Thymeleaf template
        model.addAttribute("fish", fish);

        return "fishes/fish-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("fishId") int id, Model model) {

        Fish fish = fishService.findById(id);
        //Spring model -> Thymeleaf template
        model.addAttribute("fish", fish);

        return "fishes/fish-form";
    }

}