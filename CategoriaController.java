import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/")
    public String listaCategorias(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "lista-categorias";
    }

    @GetMapping("/nueva")
    public String nuevaCategoriaForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "form-nueva-categoria";
    }

    @PostMapping("/nueva")
    public String nuevaCategoriaSubmit(@ModelAttribute Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorias/";
    }
}
