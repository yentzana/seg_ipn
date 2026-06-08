package mx.seg.ipn.aplicacion.notas.infrastructure;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import mx.seg.ipn.aplicacion.config.FeignClientConfiguration;
import mx.seg.ipn.aplicacion.notas.model.UsuarioNotasResponse;

/**
 * Feign para la consulta del servicio.
 */
@FeignClient(configuration = FeignClientConfiguration.class, name = "serviceNow", 
	url = "${gnp.tramites.siq.url}")
public interface BusquedaSiqUserClient {
	/**
	 * 
	 * @param queryUser nombre del usuario de la nota.
	 * @param fieldsUser datos a devolver.
	 * @param valueUser mostrar el usuario.
	 * @param linkUser quitar los enlaces.
	 * @return nombre del usuario asociado a las notas.
	 */
	@GetMapping(
			value = "/api/now/table/sys_user",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	UsuarioNotasResponse getDetalleUsuario(
			@RequestParam("sysparm_query") String queryUser,
			@RequestParam("sysparm_fields") String fieldsUser,
			@RequestParam("sysparm_display_value") String valueUser,
			@RequestParam("sysparm_exclude_reference_link") String linkUser
	);
}