package cl.duoc.risani.sosdrink.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String detalle;
    private Integer precio;
    private String imagen;
    private Integer stock;
    private Integer criticalStock;
    private String category;

    @OneToMany(mappedBy = "producto")
    private List<Producto> productos;

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", detalle=" + detalle + ", precio=" + precio
                + ", imagen=" + imagen + ", stock=" + stock + ", criticalStock=" + criticalStock + ", category="
                + category + "]";
    }



   

}