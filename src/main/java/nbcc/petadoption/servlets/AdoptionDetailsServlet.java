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

@WebServlet("/adoption")
public class AdoptionDetailsServlet extends HttpServlet {
    private PetRepository petRepo;
    private AdoptionRepository adoptionRepo;

    public void init(){
        petRepo = PetRepoFactory.getPetRepo();
        adoptionRepo = AdoptionRepoFactory.getAdoptionRepo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> pets = petRepo.getAll();
        request.setAttribute("pets", pets);
        List<AdoptionViewModel>  adoptions = getViewModels();
        request.setAttribute("adoptions", adoptions);

        request.getRequestDispatcher("/adoption.jsp").forward(request, response);

    }

    private List<AdoptionViewModel> getViewModels(){

        List<Adoption> adoptions = adoptionRepo.getAll();
        List<AdoptionViewModel> viewModels = new ArrayList<>();
        for(Adoption adoption : adoptions){
            AdoptionViewModel viewModel = new AdoptionViewModel();
            Pet pet = petRepo.get(adoption.getPetId());

            viewModel.setPet(pet);
            viewModel.setAdoption(adoption);
            viewModels.add(viewModel);
        }
        return viewModels;
    }
}
