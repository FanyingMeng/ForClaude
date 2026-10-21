package nbcc.assignmentservlet.repositories;

import nbcc.assignmentservlet.entities.Course;

import java.util.ArrayList;
import java.util.List;

//Do not modify this class, it already works as intended to pull data from memory
public class CourseMockMemoryRepository implements CourseRepository{

    private final List<Course> courses;

    public CourseMockMemoryRepository() {
        this.courses = new ArrayList<>();
        this.courses.add(new Course(1L, "Server Side Web", 90));
        this.courses.add(new Course(2L, "Enterprise Java", 90));
        this.courses.add(new Course(3L, "PHP", 45));
        this.courses.add(new Course(4L, "Advanced JavaScript", 90));
    }

    @Override
    public List<Course> getAll() {
        return courses;
    }

    @Override
    public Course get(Long id) {

        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }

        return null;
    }
}
