package cl.duoc.risani.sosdrink.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.duoc.risani.sosdrink.backend.entities.Blog;
import cl.duoc.risani.sosdrink.backend.entities.CategoriaBlog;
import cl.duoc.risani.sosdrink.backend.repository.BlogRepository;
import cl.duoc.risani.sosdrink.backend.repository.CategoriaBlogRepository;

@Service
public class BlogServicesImpl implements BlogServices {

    @Autowired
    BlogRepository blogRepo;

    @Autowired
    CategoriaBlogRepository categoriaBlogRepo;

    // Blogs

    @Override
    @Transactional(readOnly = true)
    public List<Blog> listarBlogs() {
        return (List<Blog>) blogRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Blog> obtenerBlog(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean blogExiste(Long id) {
        return obtenerBlog(id).isPresent();
    }

    @Override
    @Transactional
    public Blog guardarBlog(Blog blog) {
        return blogRepo.save(blog);
    }

    @Override
    @Transactional
    public Optional<Blog> eliminarBlog(Blog blog) {
        Optional<Blog> obtenido = obtenerBlog(blog.getId());
        obtenido.ifPresent(blogDb -> {
            blogRepo.delete(blogDb);
        });
        return obtenido;
    }

    // Categoria

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaBlog> listarCategoriasBlog() {
        return (List<CategoriaBlog>) categoriaBlogRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CategoriaBlog> obtenerCategoriaBlog(Long id) {
        return categoriaBlogRepo.findById(id);
    }

    @Override
    @Transactional
    public CategoriaBlog guardarCategoriaBlog(CategoriaBlog categoriaBlog) {
        return categoriaBlogRepo.save(categoriaBlog);
    }

    @Override
    @Transactional
    public Optional<CategoriaBlog> eliminarCategoriaBlog(CategoriaBlog categoriaBlog) {
        Optional<CategoriaBlog> obtenido = obtenerCategoriaBlog(categoriaBlog.getId());
        obtenido.ifPresent(catDb -> {
            categoriaBlogRepo.delete(catDb);
        });
        return obtenido;
    }

}
