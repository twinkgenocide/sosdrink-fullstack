package cl.duoc.risani.sosdrink.backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String resumen;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    private String contenido;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @Column
    private String imagenUrl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_blog_id", nullable = false)
    private CategoriaBlog categoriaBlog;

}
