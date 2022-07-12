package net.ibk.clientes.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @NonNull
    private String id;
    @NonNull
    private String tipoDocumento;
    @NonNull
    private String numeroDocumento;
    @NonNull
    private String nombres;
    @NonNull
    private String apellidos;

}
