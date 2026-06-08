package mx.seg.ipn.aplicacion.notas.infrastructure;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import mx.seg.ipn.aplicacion.config.FeignClientConfiguration;
import mx.seg.ipn.aplicacion.notas.model.SiqNotasResponse;

/**
 * Feign para la consulta del servicio.
 */
@FeignClient(configuration = FeignClientConfiguration.class, name = "serviceNow", 
	url = "${gnp.tramites.siq.url}")
public interface BusquedaSiqNotasClient {
	/**
	 * 
	 * @param query fieldname y documentkey a buscar.
	 * @param fields datos a devolver.
	 * @return devuelve las notas asociadas a un identificador Siq.
	 */
	@GetMapping(
			value = "/api/now/table/sys_audit",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	SiqNotasResponse getDetalleNotas(
			@RequestParam("sysparm_query") String query,
			@RequestParam("sysparm_fields") String fields
	);
}