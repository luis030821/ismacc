package com.example.controller;

import com.example.model.Libro;
import com.example.model.Autor;
import com.example.model.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/libros")
public class LibroController extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("LibreriaPU");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        request.setAttribute("libros", libros);
        request.getRequestDispatcher("/libros-listar.jsp").forward(request, response);
        em.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        EntityManager em = emf.createEntityManager();
        if ("add".equals(action)) {
            // Manejo de la adición de un nuevo libro
            String titulo = request.getParameter("titulo");
            int idAutor = Integer.parseInt(request.getParameter("autor"));
            int idCategoria = Integer.parseInt(request.getParameter("categoria"));
            double precio = Double.parseDouble(request.getParameter("precio"));

            Autor autor = em.find(Autor.class, idAutor);
            Categoria categoria = em.find(Categoria.class, idCategoria);

            Libro libro = new Libro();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setCategoria(categoria);
            libro.setPrecio(precio);

            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } else if ("del".equals(action)) {
            // Manejo de la eliminación de un libro existente
            int idLibro = Integer.parseInt(request.getParameter("libro"));
            Libro libro = em.find(Libro.class, idLibro);

            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        }
        em.close();
        response.sendRedirect("libros");
    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
