package med.clinica.api.controller;

import jakarta.validation.Valid;
import med.clinica.api.medico.DatosRegistroMedico;
import med.clinica.api.medico.Medico;
import med.clinica.api.medico.MedicorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController //para que pueda leer protocolo REST
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicorRepository medicorRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){ //@RequestBody es para que lea el body del JSON

        medicorRepository.save(new Medico(datosRegistroMedico));
    }
}
