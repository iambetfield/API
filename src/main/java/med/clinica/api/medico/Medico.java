package med.clinica.api.medico;

import jakarta.persistence.*;
import lombok.*;
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
    private String telefono;

    private boolean activo;
    @Enumerated
    private Especialidad especialidad;
    @Embedded //para que no genere una tabla, sino un atributo dentro de una clase
    private Direccion direccion;


    public Medico(DatosRegistroMedico datosRegistroMedico){
        this.activo = true;
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.telefono = datosRegistroMedico.telefono();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        //validación, si los datos no son nulos,cambialos
        if(datosActualizarMedico.nombre() != null){
            this.nombre = datosActualizarMedico.nombre();
        }
        if (datosActualizarMedico.documento() != null){
            this.documento = datosActualizarMedico.documento();
        }
        if(datosActualizarMedico.direccion() != null){
            this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
        }



    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
