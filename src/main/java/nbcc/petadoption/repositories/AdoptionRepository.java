package nbcc.petadoption.repositories;

import nbcc.petadoption.entities.Adoption;

import java.util.List;

public interface AdoptionRepository {
    List<Adoption> getAll();
    Adoption get(Long id);
    void insert(Adoption adoption);

}
