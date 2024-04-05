package Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empresa", schema = "ohara")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(exclude = {"personal", "empresa", "token"})
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rsocial", nullable = false, length = 100)
    private String razonSocial;
}
