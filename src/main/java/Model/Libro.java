package Model;

import Model.Enum.TipoCategoria;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "libro", schema = "ohara")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"categorias"})
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 13)
    private String isbn;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(length = 255)
    private String autor;

    @Column(length = 50)
    private String formato; // 0-Digital 1-Físico ¿¿Bolsillo, T.Dura, etc.??

    @Column(length = 500)
    private String imagen;

    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta = new Date();

    @Column(name = "estado_libro")
    private int estadoLibro = 0; // 0-Disponible 1-Vendido 2-No Disponible (temporalmente)

    @Column(nullable = false)
    private boolean recibido = false;

    @Column(nullable = false)
    private Integer valoracion; // 1 to 5

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private TipoCategoria categorias;
}
