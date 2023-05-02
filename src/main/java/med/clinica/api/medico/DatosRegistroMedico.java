package med.clinica.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.clinica.api.direccion.DatosDireccion;

public record DatosRegistroMedico( //usamos validaciones de alto nivel con el paquete Validation de Spring
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefono,
        @NotBlank
        @Pattern(regexp="\\d{8,9}") //entre 8 y 9 dígitos << regular expresion deseada como patrón de validación
        String documento,
        @NotNull //porque es un enum
        Especialidad especialidad,
        @NotNull // no va NotBlank porque es un objeto, y si no hay nada, el valor el null
        @Valid // le indicamos que valide las anotaciones que pusimos en DatosDireccion
        DatosDireccion direccion) {

}
