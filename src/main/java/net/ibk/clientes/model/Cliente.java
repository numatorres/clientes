package net.ibk.clientes.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
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
