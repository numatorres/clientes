package net.ibk.clientes.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCliente")
    private Long idCliente;

    @NonNull
    @Column(name = "codigoUnico")
    private String codigoUnico;

    @NonNull
    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @NonNull
    @Column(name = "nombres")
    private String nombres;

    @NonNull
    @Column(name = "apellidos")
    private String apellidos;

    @NonNull
    @Column(name = "idTipoDocumento")
    private Long idTipoDocumento;

    /*@ManyToOne
    private TipoDocumento tipoDocumento;*/

}
