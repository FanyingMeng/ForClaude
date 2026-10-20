package nbcc.assignmentservlet.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nbcc.assignmentservlet.entities.Course;
import nbcc.assignmentservlet.entities.CourseRegistration;
import nbcc.assignmentservlet.factories.CourseRegistrationRepoFactory;
import nbcc.assignmentservlet.factories.CourseRepoFactory;
import nbcc.assignmentservlet.repositories.CourseRegistrationRepository;
import nbcc.assignmentservlet.repositories.CourseRepository;

import java.io.IOException;

@WebServlet("/registration")
public class CourseRegistrationServlet extends HttpServlet {

    private CourseRepository courseRepo;
    private CourseRegistrationRepository courseRegistrationRepo;

    @Override
    public void init() {
        courseRepo = CourseRepoFactory.getCourseRepo();
        courseRegistrationRepo = CourseRegistrationRepoFactory.getCourseRegistrationRepo();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Todo Implement this method
        request.setAttribute("courses",courseRepo.getAll());
        getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Todo Implement this method
        CourseRegistration courseRegistration = convertToRegistration(request);
        courseRegistrationRepo.insert(courseRegistration);

        response.sendRedirect("courses");
    }

    private CourseRegistration convertToRegistration(HttpServletRequest request) {

        long courseId = Long.parseLong(request.getParameter("courseId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourseId(courseId);
        courseRegistration.setFirstName(firstName);
        courseRegistration.setLastName(lastName);


        return courseRegistration;
    }
}
