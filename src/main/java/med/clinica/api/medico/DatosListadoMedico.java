package med.clinica.api.medico;

//creo un record para filtrar los datos que queremos que traiga la peticion GET
public record DatosListadoMedico(Long id, String nombre, String especialidad, String documento, String email ) {
    //constructor
    public DatosListadoMedico(Medico medico){
        this(medico.getId(), medico.getNombre(),medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}
