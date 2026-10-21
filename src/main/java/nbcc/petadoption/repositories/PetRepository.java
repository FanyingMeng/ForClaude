package nbcc.petadoption.repositories;

import nbcc.petadoption.entities.Pet;

import java.util.List;

public interface PetRepository {
    List<Pet> getAll();
    Pet get(Long id);
}
