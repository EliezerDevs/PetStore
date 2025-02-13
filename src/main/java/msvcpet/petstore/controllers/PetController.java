package msvcpet.petstore.controllers;

import msvcpet.petstore.entities.Pet;
import msvcpet.petstore.entities.PetStatus;
import msvcpet.petstore.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }


    @GetMapping("/{idPet}")
    public ResponseEntity<Pet> getPet(@PathVariable(value = "idPet") Integer id) {
        Optional<Pet> anyPet = this.petService.getPetById(id);
        if(anyPet.isPresent()) {
            return ResponseEntity.ok(anyPet.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<PetStatus> updatePet(@RequestBody Pet pet) {
        Optional<PetStatus> petStatus =this.petService.editPetById(pet) ;
        if(petStatus.isPresent()) {
            return ResponseEntity.ok(petStatus.get());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
