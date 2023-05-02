package med.clinica.api.direccion;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Direccion {
    private String calle;
    private String numero;
    private String ciudad;
    private String complemento;

    public Direccion(DatosDireccion datosDireccion){
        this.calle= datosDireccion.calle();
        this.numero = datosDireccion.numero();
        this.ciudad = datosDireccion.ciudad();
        this.complemento = datosDireccion.complemento();
    }
}
