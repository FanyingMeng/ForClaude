package nbcc.assignmentservlet.factories;

import nbcc.assignmentservlet.repositories.CourseMockMemoryRepository;
import nbcc.assignmentservlet.repositories.CourseRepository;

public class CourseRepoFactory {

    public static CourseRepository getCourseRepo() {
        return new CourseMockMemoryRepository();
    }
}
