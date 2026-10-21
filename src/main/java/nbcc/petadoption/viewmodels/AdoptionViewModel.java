package nbcc.petadoption.viewmodels;

import nbcc.petadoption.entities.Adoption;
import nbcc.petadoption.entities.Pet;

public class AdoptionViewModel {
    private Adoption adoption;
    private Pet pet;

    public AdoptionViewModel() {
    }

    public Adoption getAdoption() {
        return adoption;
    }

    public void setAdoption(Adoption adoption) {
        this.adoption = adoption;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
