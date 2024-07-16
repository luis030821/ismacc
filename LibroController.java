import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/")
    public String listaLibros(Model model) {
        model.addAttribute("libros", libroRepository.findAll());
        return "lista-libros";
    }

    @GetMapping("/nuevo")
    public String nuevoLibroForm(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("autores", autorRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "form-nuevo-libro";
    }

    @PostMapping("/nuevo")
    public String nuevoLibroSubmit(@ModelAttribute Libro libro) {
        libroRepository.save(libro);
        return "redirect:/libros/";
    }

    @GetMapping("/editar/{id}")
    public String editarLibroForm(@PathVariable("id") int id, Model model) {
        Libro libro = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de libro inválido: " + id));
        model.addAttribute("libro", libro);
        model.addAttribute("autores", autorRepository.findAll());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "form-editar-libro";
    }

    @PostMapping("/editar/{id}")
    public String editarLibroSubmit(@PathVariable("id") int id, @ModelAttribute Libro libro) {
        libro.setIdLibro(id);
        libroRepository.save(libro);
        return "redirect:/libros/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable("id") int id) {
        Libro libro = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de libro inválido: " + id));
        libroRepository.delete(libro);
        return "redirect:/libros/";
    }
}
