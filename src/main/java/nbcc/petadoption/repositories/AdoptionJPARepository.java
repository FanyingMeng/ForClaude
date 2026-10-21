package nbcc.petadoption.repositories;

import jakarta.persistence.*;
import nbcc.petadoption.entities.Adoption;

import java.util.List;

public class AdoptionJPARepository implements AdoptionRepository {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    @Override
    public List<Adoption> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Adoption> query = em.createQuery("Select a from Adoption a", Adoption.class);
            return query.getResultList();
        }
    }

    @Override
    public Adoption get(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Adoption.class, id);

        }
    }

    @Override
    public void insert(Adoption adoption) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(adoption);
            tx.commit();
        }

    }
}
