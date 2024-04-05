package Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "donacion", schema = "ohara")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"usuario", "libro", "solicitudDonacion"})
public class Donacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_donacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDonacion = new Date();

    @Column(nullable = false)
    private boolean devolucion = false;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "id_solicitud_donacion")
    private SolicitudDonacion solicitudDonacion;
}
