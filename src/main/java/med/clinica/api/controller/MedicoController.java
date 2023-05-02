package med.clinica.api.controller;

import jakarta.validation.Valid;
import med.clinica.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController //para que pueda leer protocolo REST
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicorRepository medicorRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) { //@RequestBody es para que lea el body del JSON @Valid<< para que valide

        medicorRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping()
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 3) Pageable paginacion) { //Paginas, necesitamos trabajar con un parámetro del front end llamado Paggeable
        //este método se encarga de obtener una lista de todos los médicos de la base de datos a través de medicorRepository, transformar cada objeto Medico en un objeto DatosListadoMedico y devolver una lista de objetos DatosListadoMedico
        return medicorRepository.findAll(paginacion).map(DatosListadoMedico::new); //mapeando cada elemento de la paginacion, y nos mapea en nuevas entidades medico
    }

    //listado de médicos activos
    @GetMapping()
    public Page<DatosListadoMedico> listadoMedicosActivos(@PageableDefault(size = 3) Pageable paginacion) { //Paginas, necesitamos trabajar con un parámetro del front end llamado Paggeable
        //este método se encarga de obtener una lista de todos los médicos de la base de datos a través de medicorRepository, transformar cada objeto Medico en un objeto DatosListadoMedico y devolver una lista de objetos DatosListadoMedico
        return medicorRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new); //mapeando cada elemento de la paginacion, y nos mapea en nuevas entidades medico
    }
    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico = medicorRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicorRepository.getReferenceById(id);
        medicorRepository.delete(medico); //borrado fisico

    }

    //el borrado logico se hace con una flag, un campo que diga el médico activo y el que no, se hace con una migration

    //con el borrado lógico se hace un update para cambiarle el valor al boolean
    @PutMapping("/{id}")
    @Transactional
    public void desactivarMedico(@PathVariable Long id){
        Medico medico = medicorRepository.getReferenceById(id);
        medico.desactivarMedico();  //borrado logico
    }

}
