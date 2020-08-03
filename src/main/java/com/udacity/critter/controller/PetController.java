package com.udacity.critter.controller;

import com.udacity.critter.dto.PetDTO;
import com.udacity.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }


    public PetDTO savePet(PetDTO petDTO) {
        return null;
    }

    public PetDTO getPet(long id) {
        return null;
    }


    public List<PetDTO> getPetsByOwner(long id) {
        return null;
    }
}
