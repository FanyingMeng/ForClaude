package nbcc.assignmentservlet.entities;
import jakarta.persistence.*;
//Todo Make this an Entity
@Entity
@Table(name = "courseregistration")
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false)
    private Long courseId;

    @Column( nullable = false)
    private String firstName;

    @Column( nullable = false)
    private String lastName;

    public CourseRegistration() {
    }

    public long getId() {
        return id;
    }

    public CourseRegistration setId(Long id) {
        this.id = id;
        return this;
    }

    public long getCourseId() {
        return courseId;
    }

    public CourseRegistration setCourseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CourseRegistration setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CourseRegistration setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
