package net.ibk.clientes.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TipoDocumento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTipoDocumento")
    private Long idTipoDocumento;

    @Column(name = "tipoDocumento", length=30, nullable=false, unique=true)
    private String tipoDocumento;

    public TipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public TipoDocumento(Long idTipoDocumento, String tipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
        this.tipoDocumento = tipoDocumento;
    }

    public TipoDocumento(long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
}
