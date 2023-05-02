package med.clinica.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.clinica.api.direccion.Direccion;
@Entity(name = "Médico")
@Table(name="medicos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") //usa el parámetro ID para la comparación entre los médicos
@Getter
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    @Enumerated
    private Especialidad especialidad;
    @Embedded //para que no genere una tabla, sino un atributo dentro de una clase
    private Direccion direccion;


    public Medico(DatosRegistroMedico datosRegistroMedico){
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }
}
