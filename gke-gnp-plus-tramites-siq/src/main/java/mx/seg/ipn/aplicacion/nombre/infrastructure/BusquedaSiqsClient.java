package mx.seg.ipn.aplicacion.nombre.infrastructure;

import org.springframework.http.MediaType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import mx.seg.ipn.aplicacion.config.FeignClientConfiguration;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiqResponse;

/**
 * Feign para la consulta del servicio.
 */
@FeignClient(configuration = FeignClientConfiguration.class, name = "serviceNow", 
	url = "${gnp.tramites.siq.url}")
public interface BusquedaSiqsClient {
	/**
	 * 
	 * @param query contratante y ramo a buscar.
	 * @param value se utiliza para hacer la conversión del estatus.
	 * @param fields datos a devolver.
	 * @param links especifica si se deben excluir los enlaces de referencia.
	 * @return devuelve los siqs asociados al contratante y ramo.
	 */
	@GetMapping(
			value = "/api/now/table/sn_customerservice_complain",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	DatosSiqResponse getDetalelleNombre(
			@RequestParam("sysparm_query") String query,
			@RequestParam("sysparm_display_value") String value,
			@RequestParam("sysparm_fields") String fields,
			@RequestParam("sysparm_exclude_reference_link") String links
	);
}