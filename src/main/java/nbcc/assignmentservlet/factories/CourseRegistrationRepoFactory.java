package nbcc.assignmentservlet.factories;

import nbcc.assignmentservlet.repositories.CourseRegistrationJPARepository;
import nbcc.assignmentservlet.repositories.CourseRegistrationRepository;

public class CourseRegistrationRepoFactory {

    public static CourseRegistrationRepository getCourseRegistrationRepo() {
        return new CourseRegistrationJPARepository();
    }
}
