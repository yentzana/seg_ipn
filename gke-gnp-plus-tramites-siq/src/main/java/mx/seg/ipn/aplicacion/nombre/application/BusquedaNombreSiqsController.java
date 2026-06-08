package mx.seg.ipn.aplicacion.nombre.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import mx.seg.ipn.aplicacion.nombre.domain.incoming.BusquedaNombreSiqsLogic;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiqDetalleResponse;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiqRequest;
import mx.seg.ipn.aplicacion.utils.ConstantesFolio;
import java.util.List;

/**
 * Controlador para exponer el endpoint para la consulta de Siqs por nombre y ramo.
 */
@RestController
@RequestMapping("/persona")
@CrossOrigin
@Slf4j
@Tag(name = "Busqueda por nombre del contratante o reclamante.")
public class BusquedaNombreSiqsController {
	/** Instancia del Service. **/
	@Autowired
	private BusquedaNombreSiqsLogic busquedaNombreSiqsLogic;

	/**
	 * 
	 * Devuelve los Siqs por el nombre del contratante.
	 * @param polizas listado de polizas para la consulta.
	 * @param ramo ramo asociado a los siqs.
     * @param fechaInicio fecha de inicio para el filtrado.
     * @param fechaFin fecha fin para el filtrado
	 * @return siqs asociados al nombre del contratante.
	 */
	@Operation(summary = "Busqueda de las Siqs por nombre del contratante o reclamante para el portal de Plus.")
	@ApiResponses({
        @ApiResponse(responseCode = ConstantesFolio.CODIGO_EXITOSO, description = ConstantesFolio.SIQ_200_NOMBRE),
        @ApiResponse(responseCode = ConstantesFolio.CODIGO_ERROR_INISPERADO, description = ConstantesFolio.ERROR_500)
	})
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public DatosSiqDetalleResponse getSiqNombre(
    		@Schema(description = "Lista de pólizas asociadas a una persona moral o física.", example = "[\"00000168846277\", \"00000427076948\"]")
			final @RequestBody(required = true) List<String> polizas,
			@Parameter(description = "Ramo de la Siq, este puede recibir las siguientes nomenclaturas:"
    			+ "gmm - ramo=Gastos Medicos, vida - ramo=Vida, autos - ramo=Autos, "
    			+ "danios - ramo=Daños, todos - Todos los ramos.", example = "todos")
			final @RequestParam(required = false) String ramo,
			@Parameter(name = "fechaInicio", example = "2022-01-01", required = false, description = "Fecha de inicio")
			final @RequestParam(required = false) String fechaInicio,
            @Parameter(name = "fechaFin", example = "2024-05-24", required = false, description = "Fecha fin")
			final @RequestParam(required = false) String fechaFin) {
		log.info("Se realiza la consulta de SIQS asociados por las polizas de una persona fisica.");
        DatosSiqRequest request = new DatosSiqRequest();
		request.setPolizas(polizas);
        request.setRamo(ramo);
        request.setFechaFin(fechaFin);
        request.setFechaIncio(fechaInicio);
        return  busquedaNombreSiqsLogic.getSiqsNombre(request);
    }
}