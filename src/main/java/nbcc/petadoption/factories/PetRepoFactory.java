package nbcc.petadoption.factories;

import nbcc.petadoption.repositories.PetMockMemoryRepository;
import nbcc.petadoption.repositories.PetRepository;

public class PetRepoFactory {
    public static PetRepository getPetRepo(){
        return new PetMockMemoryRepository();
    }
}
