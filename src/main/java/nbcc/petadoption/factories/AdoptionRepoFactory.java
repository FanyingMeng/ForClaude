package nbcc.petadoption.factories;

import nbcc.petadoption.repositories.AdoptionJPARepository;
import nbcc.petadoption.repositories.AdoptionRepository;

public class AdoptionRepoFactory {
    public static AdoptionRepository getAdoptionRepo(){
        return new AdoptionJPARepository();
    }
}
