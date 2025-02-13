package msvcpet.petstore.services;
import java.time.LocalDateTime;
import msvcpet.petstore.entities.Pet;
import msvcpet.petstore.entities.PetPost;
import msvcpet.petstore.entities.PetStatus;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
public class PetServiceImpl implements PetService {


    private final String PET_SWAGGER_EXTERNAL = "https://petstore.swagger.io/v2/pet/";


    @Override
    public Optional<Pet> getPetById(Integer id) {

        StringBuffer url = new StringBuffer(this.PET_SWAGGER_EXTERNAL);
        url.append(id);

        System.out.println(url.toString());
        RestTemplate restTemplate = new RestTemplate();

        try {
            Pet anyAnimal = restTemplate.getForObject(url.toString(), Pet.class);
            System.out.println(anyAnimal.getName());
            System.out.println(anyAnimal.getId());
            System.out.println(anyAnimal.getStatus());
            return Optional.of(anyAnimal);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<PetStatus> editPetById(Pet pet) {

        StringBuffer url = new StringBuffer("https://petstore.swagger.io/v2/pet/");
        System.out.println(url.toString());

        RestTemplate restTemplate = new RestTemplate();

        try {
            PetPost newPet = new PetPost();
            PetStatus newPetstatus = new PetStatus();

            newPet.setName(pet.getName());
            newPet.setStatus(pet.getStatus().toString());


            newPetstatus.setStatus(pet.getStatus().equals("available") ? true : false);


            newPetstatus.setDateCreated(LocalDateTime.now());
            newPetstatus.setTransatcionId(UUID.randomUUID());
            newPetstatus.setName(pet.getName());

            System.out.printf("{\n\ttransactionId: %s\n\tdateCreated: %s\n\tstatus: %s\n\tname: %s\n}\n",
                    newPetstatus.getTransatcionId(),
                    newPetstatus.getDateCreated(),
                    newPetstatus.getStatus(),
                    newPetstatus.getName());

            System.out.println(url.toString());

            restTemplate.postForEntity(url.toString(), newPet, PetPost.class);

            return Optional.of(newPetstatus);
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
