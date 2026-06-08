package mx.seg.ipn.aplicacion.notas.application;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Request;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import mx.seg.ipn.aplicacion.notas.domain.incoming.BusquedaSiqNotasLogic;
import mx.seg.ipn.aplicacion.notas.model.SiqNotasRequest;
import mx.seg.ipn.aplicacion.notas.model.SiqNotasResponse;
import mx.seg.ipn.aplicacion.seguridad.infrastructure.repository.CatGeneroRepository;
import mx.seg.ipn.aplicacion.seguridad.infrastructure.repository.PersonaRepository;
import mx.seg.ipn.aplicacion.utils.ConstantesFolio;

/**
 * Controlador para exponer el endpoint para la consulta de notas SIQ por identificador del SIQ.
 */
@RestController
@RequestMapping("/notas/{identificadorSiq}")
@CrossOrigin
@Slf4j
@Tag(name = "Búsqueda de notas por identificador de la SIQ.")
public class BusquedaSiqNotasController {
	/** Instancia del servicio. **/
	@Autowired
	private BusquedaSiqNotasLogic busquedaSiqNotasLogic;
	
	@Autowired
	private  CatGeneroRepository repository;
	
	@Autowired
	private  PersonaRepository repositoryPersona;
	
//	@Autowired(required=true)
//	private HttpRequest x;
	
	
	/**
	 * Devuelve las notas asociadas a un identificador SIQ.
	 * @param identificadorSiq identificador SIQ.
	 * @return las notas asociadas a un identificador de SIQ dado.
	 */
	@Operation(summary = "Búsqueda de las notas SIQ asociadas al identificador de la SIQ para el portal de Plus.")
	@ApiResponses({
        @ApiResponse(responseCode = ConstantesFolio.CODIGO_EXITOSO, description = ConstantesFolio.SIQ_NOTAS),
        @ApiResponse(responseCode = ConstantesFolio.CODIGO_ERROR_INISPERADO, description = ConstantesFolio.ERROR_500)
	})
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public SiqNotasResponse getSiqNotas(
			@Parameter(description = "Identificador de la SIQ", example = "04ba9ce1db560a9039d8d9fcd39619d8")
			final @PathVariable(required = true) String identificadorSiq) {
		log.info("Se realiza la consulta de notas SIQ asociadas a un identificador. " + identificadorSiq);
        SiqNotasRequest request = new SiqNotasRequest();
//        x.headers();
        repository.findAll();
        repository.findById("X");
        
        repositoryPersona.findAll();
        
//        request.setIdentificadorSiq(identificadorSiq);
        return null;
        // busquedaSiqNotasLogic.getNotasSiq(request);
	}
}