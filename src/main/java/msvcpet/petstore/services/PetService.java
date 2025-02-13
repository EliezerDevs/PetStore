package msvcpet.petstore.services;

import msvcpet.petstore.entities.Pet;
import msvcpet.petstore.entities.PetStatus;

import java.util.Optional;

public interface PetService {

    Optional<Pet> getPetById(Integer id);

    Optional<PetStatus> editPetById(Pet pet);

}
