package nbcc.petadoption.repositories;

import nbcc.petadoption.entities.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetMockMemoryRepository implements PetRepository {

    private final List<Pet> pets;

    public PetMockMemoryRepository() {
        this.pets = new ArrayList<>();
        this.pets.add(new Pet(1L,"Buddy","Dog",3));
        this.pets.add(new Pet(2L,"Whiskers","Cat",2));
        this.pets.add(new Pet(3L,"Nibbles","Rabbit",1));
        this.pets.add(new Pet(4L,"Polly","Parrot",5));
    }

    @Override
    public List<Pet> getAll() {
        return pets;
    }

    @Override
    public Pet get(Long id) {
        for (Pet pet : pets) {
            if(pet.getId() == id){
                return pet;
            }
        }
        return null;
    }
}
