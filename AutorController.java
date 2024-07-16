import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/")
    public String listaAutores(Model model) {
        model.addAttribute("autores", autorRepository.findAll());
        return "lista-autores";
    }

    @GetMapping("/nuevo")
    public String nuevoAutorForm(Model model) {
        model.addAttribute("autor", new Autor());
        return "form-nuevo-autor";
    }

    @PostMapping("/nuevo")
    public String nuevoAutorSubmit(@ModelAttribute Autor autor) {
        autorRepository.save(autor);
        return "redirect:/autores/";
    }
}
