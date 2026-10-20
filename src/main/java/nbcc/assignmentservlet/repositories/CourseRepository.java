package nbcc.assignmentservlet.repositories;

import nbcc.assignmentservlet.entities.Course;
import nbcc.assignmentservlet.entities.CourseRegistration;

import java.util.List;

public interface CourseRepository {
    List<Course> getAll();
    Course get(Long id);
}
