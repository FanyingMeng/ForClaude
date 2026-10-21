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
import nbcc.petadoption.viewmodels.AdoptionViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/","/pets"})
public class PetsServlet extends HttpServlet {
    private PetRepository petRepo;


    public void init(){
        petRepo = PetRepoFactory.getPetRepo();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = petRepo.getAll();
        request.setAttribute("pets", pets);

        request.getRequestDispatcher("pets.jsp").forward(request, response);

    }


}
