package net.ibk.clientes.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes")

public class Cliente implements Serializable {

    private static final long serialVersionUID = -78719825L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCliente")
    private Long idCliente;

    @Column(name = "codigoUnico", length = 8, nullable = false, unique = true)
    private String codigoUnico;

    @Column(name = "numeroDocumento", length = 20, nullable = false, unique = true)
    private String numeroDocumento;

    @Column(name = "nombres", length = 50, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @JoinColumn(name = "idTipoDocumento")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoDocumento tipoDocumento;

    public Cliente(String codigoUnico, String numeroDocumento, String nombres, String apellidos, TipoDocumento tipoDocumento) {
        this.codigoUnico = codigoUnico;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
    }
}
