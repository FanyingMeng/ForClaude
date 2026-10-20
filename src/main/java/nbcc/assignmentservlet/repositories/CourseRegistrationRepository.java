package nbcc.assignmentservlet.repositories;

import nbcc.assignmentservlet.entities.CourseRegistration;

import java.util.List;

public interface CourseRegistrationRepository {
    List<CourseRegistration> getAll();
    CourseRegistration get(Long id);
    void insert(CourseRegistration courseRegistration);
}
