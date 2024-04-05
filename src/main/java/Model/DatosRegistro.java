package Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "datos_registro", schema = "ohara")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"usuario"})
public class DatosRegistro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8)
    private String documento;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String direccion;

    @Column(length = 9)
    private String telefono;

    @Column(name = "cuenta_paypal", length = 100)
    private String cuentaPaypal;

    @Column(nullable = false)
    private boolean validado = false;

    @Column(name = "fecha_alta")
    private Date fechaAlta = new Date();

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
