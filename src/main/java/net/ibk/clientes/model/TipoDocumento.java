package net.ibk.clientes.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="TipoDocumento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTipoDocumento")
    private Long idTipoDocumento;

    @NonNull
    @Column(name = "tipoDocumento")
    private String tipoDocumento;

}
