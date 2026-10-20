package nbcc.assignmentservlet.entities;

public class Course {

    private long id;

    private String name;

    private int creditHours;

    public Course() {
    }

    public Course(long id, String name, int creditHours) {
        this.id = id;
        this.name = name;
        this.creditHours = creditHours;
    }

    public long getId() {
        return id;
    }

    public Course setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public Course setCreditHours(int creditHours) {
        this.creditHours = creditHours;
        return this;
    }
}
