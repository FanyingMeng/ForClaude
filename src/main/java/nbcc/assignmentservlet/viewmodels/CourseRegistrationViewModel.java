package nbcc.assignmentservlet.viewmodels;

import nbcc.assignmentservlet.entities.Course;
import nbcc.assignmentservlet.entities.CourseRegistration;

public class CourseRegistrationViewModel {

    private CourseRegistration courseRegistration;
    private Course course;

    public CourseRegistrationViewModel() {
    }

    public CourseRegistration getCourseRegistration() {
        return courseRegistration;
    }

    public CourseRegistrationViewModel setCourseRegistration(CourseRegistration courseRegistration) {
        this.courseRegistration = courseRegistration;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public CourseRegistrationViewModel setCourse(Course course) {
        this.course = course;
        return this;
    }
}
