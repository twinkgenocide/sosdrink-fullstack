package cl.duoc.risani.sosdrink.backend.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.risani.sosdrink.backend.entities.Blog;
import cl.duoc.risani.sosdrink.backend.entities.CategoriaBlog;
import cl.duoc.risani.sosdrink.backend.services.BlogServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {

    @Autowired
    private BlogServices blogServices;

    // Blogs

    @PostMapping
    public ResponseEntity<Blog> crearBlog(@RequestBody Blog blog) {
        Optional<CategoriaBlog> categoriaBlog = blogServices.obtenerCategoriaBlog(blog.getCategoriaBlog().getId());
        if (!categoriaBlog.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        blog.setCategoriaBlog(categoriaBlog.get());
        Blog nuevoBlog = blogServices.guardarBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoBlog);
    }

    @GetMapping
    public ResponseEntity<List<Blog>> listarBlogs(@RequestParam(required = false) Long categoria) {
        List<Blog> blogs;
        if (categoria != null) {
            Optional<CategoriaBlog> categoriaBlog = blogServices.obtenerCategoriaBlog(categoria);
            if (!categoriaBlog.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            blogs = categoriaBlog.get().getBlogs();
        } else {
            blogs = blogServices.listarBlogs();
        }
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogServices.obtenerBlog(id);
        if (!blog.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blog.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> editarBlog(@PathVariable Long id, @RequestBody Blog blogEditado) {
        Optional<Blog> blog = blogServices.obtenerBlog(id);
        Optional<CategoriaBlog> categoriaBlog = blogServices
                .obtenerCategoriaBlog(blogEditado.getCategoriaBlog().getId());

        if (!blog.isPresent() || !categoriaBlog.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Blog blogExistente = blog.get();
        blogExistente.setTitulo(blogEditado.getTitulo());
        blogExistente.setResumen(blogEditado.getResumen());
        blogExistente.setContenido(blogEditado.getContenido());
        blogExistente.setCategoriaBlog(categoriaBlog.get());

        Blog guardado = blogServices.guardarBlog(blogExistente);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogServices.obtenerBlog(id);
        if (!blog.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        blogServices.eliminarBlog(blog.get());
        return ResponseEntity.noContent().build();
    }

    // Categorías

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaBlog>> listarCategoriasBlog() {
        List<CategoriaBlog> categorias = blogServices.listarCategoriasBlog();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaBlog> crearCategoriaBlog(@RequestBody CategoriaBlog categoriaBlog) {
        CategoriaBlog nuevaCategoria = blogServices.guardarCategoriaBlog(categoriaBlog);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }

}
