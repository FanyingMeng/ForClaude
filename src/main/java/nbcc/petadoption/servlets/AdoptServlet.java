package nbcc.petadoption.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nbcc.petadoption.entities.Adoption;
import nbcc.petadoption.entities.Pet;
import nbcc.petadoption.factories.AdoptionRepoFactory;
import nbcc.petadoption.factories.PetRepoFactory;
import nbcc.petadoption.repositories.AdoptionRepository;
import nbcc.petadoption.repositories.PetRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/adopt")
public class AdoptServlet extends HttpServlet {
    private PetRepository petRepo;
    private AdoptionRepository adoptionRepo;

    public void init(){
        petRepo = PetRepoFactory.getPetRepo();
        adoptionRepo = AdoptionRepoFactory.getAdoptionRepo();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = petRepo.getAll();
        request.setAttribute("pets", pets);

        getServletContext().getRequestDispatcher("adopt.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Adoption adoption = convertToAdoption(request);
        adoptionRepo.insert(adoption);

        response.sendRedirect("adoption");
    }

    private Adoption convertToAdoption(HttpServletRequest request){
        long petId = Long.parseLong(request.getParameter("petId"));
        String adopterName = request.getParameter("adopterName");
        String phone = request.getParameter("phone");

        Adoption adoption = new Adoption();
        adoption.setPetId(petId);
        adoption.setAdopterName(adopterName);
        adoption.setPhone(phone);
        return adoption;

    }
}
