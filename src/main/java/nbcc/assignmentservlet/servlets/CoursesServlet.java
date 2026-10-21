package nbcc.assignmentservlet.servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import nbcc.assignmentservlet.entities.Course;
import nbcc.assignmentservlet.entities.CourseRegistration;
import nbcc.assignmentservlet.factories.CourseRegistrationRepoFactory;
import nbcc.assignmentservlet.factories.CourseRepoFactory;
import nbcc.assignmentservlet.repositories.CourseRegistrationRepository;
import nbcc.assignmentservlet.repositories.CourseRepository;
import nbcc.assignmentservlet.viewmodels.CourseRegistrationViewModel;

@WebServlet({"/", "/courses"})
public class CoursesServlet extends HttpServlet {

    private CourseRepository courseRepo;
    private CourseRegistrationRepository courseRegistrationRepo;

    public void init() {
        courseRepo = CourseRepoFactory.getCourseRepo();
        courseRegistrationRepo = CourseRegistrationRepoFactory.getCourseRegistrationRepo();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Course> courses = courseRepo.getAll();
        request.setAttribute("courses", courses);

        List<CourseRegistrationViewModel> viewModel = getViewModel();

        request.setAttribute("registrations", viewModel);

        request.getRequestDispatcher("/courses.jsp").forward(request, response);
    }

    private List<CourseRegistrationViewModel> getViewModel() {

        List<CourseRegistration> courseRegistrations = courseRegistrationRepo.getAll();

        List<CourseRegistrationViewModel> viewModel = new ArrayList<>();

        for(CourseRegistration courseRegistration : courseRegistrations) {
            CourseRegistrationViewModel viewModelItem = new CourseRegistrationViewModel();

            Course course = courseRepo.get(courseRegistration.getCourseId());

            viewModelItem.setCourseRegistration(courseRegistration);
            viewModelItem.setCourse(course);

            viewModel.add(viewModelItem);
        }

        return viewModel;
    }

}