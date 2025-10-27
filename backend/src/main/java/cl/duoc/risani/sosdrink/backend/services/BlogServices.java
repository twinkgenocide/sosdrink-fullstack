package cl.duoc.risani.sosdrink.backend.services;

import java.util.List;
import java.util.Optional;

import cl.duoc.risani.sosdrink.backend.entities.Blog;
import cl.duoc.risani.sosdrink.backend.entities.CategoriaBlog;

public interface BlogServices {

    // Blogs

    List<Blog> listarBlogs();

    Optional<Blog> obtenerBlog(Long id);

    Boolean blogExiste(Long id);

    Blog guardarBlog(Blog blog);

    Optional<Blog> eliminarBlog(Blog blog);

    // Categoría

    List<CategoriaBlog> listarCategoriasBlog();

    Optional<CategoriaBlog> obtenerCategoriaBlog(Long id);

    CategoriaBlog guardarCategoriaBlog(CategoriaBlog categoriaBlog);

    Optional<CategoriaBlog> eliminarCategoriaBlog(CategoriaBlog categoriaBlog);

}
