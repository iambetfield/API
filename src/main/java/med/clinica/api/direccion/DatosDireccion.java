package med.clinica.api.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(@NotBlank String calle,
                             @NotBlank
                             String numero,
                             @NotBlank
                             String ciudad,
                             @NotBlank
                             String complemento) {
}
