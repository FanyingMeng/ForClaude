package nbcc.assignmentservlet.repositories;

import jakarta.persistence.*;
import nbcc.assignmentservlet.entities.CourseRegistration;

import java.util.List;

//Todo Implement this class
public class CourseRegistrationJPARepository implements CourseRegistrationRepository{

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    @Override
    public List<CourseRegistration> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<CourseRegistration> query = em.createQuery("Select c from CourseRegistration c", CourseRegistration.class);
            return query.getResultList();
        }

    }

    @Override
    public CourseRegistration get(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(CourseRegistration.class, id);
        }
    }

    @Override
    public void insert(CourseRegistration courseRegistration) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(courseRegistration);
            tx.commit();
        }
    }
}



