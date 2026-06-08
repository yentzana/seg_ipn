package mx.seg.ipn.aplicacion.notas.domain.core;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import mx.seg.ipn.aplicacion.notas.domain.incoming.BusquedaSiqNotasLogic;
import mx.seg.ipn.aplicacion.notas.infrastructure.BusquedaSiqNotasClient;
import mx.seg.ipn.aplicacion.notas.infrastructure.BusquedaSiqUserClient;
import mx.seg.ipn.aplicacion.notas.model.SiqNotas;
import mx.seg.ipn.aplicacion.notas.model.SiqNotasRequest;
import mx.seg.ipn.aplicacion.notas.model.SiqNotasResponse;
import mx.seg.ipn.aplicacion.notas.model.UsuarioNotasResponse;
import mx.seg.ipn.aplicacion.utils.ConstantesFolio;

/**
 * Implementación de los métodos para la consulta de notas asociadas a un identificador de SIQ.
 */
@Service
@Slf4j
public class BusquedaSiqNotasServiceImpl implements BusquedaSiqNotasLogic {
	/** Consulta al servicio externo para la búsqueda de notas. **/
	@Autowired
	private BusquedaSiqNotasClient busquedaSiqNotasClient;
	/** Consulta al servicio externo para la búsqueda del usuario. **/
	@Autowired
	private BusquedaSiqUserClient busquedaSiqUserClient;
	
	/**
	 * @param request datos de entrada para la búsqueda.
	 * @return notas SIQ asociadas al identificador SIQ.
	 */
	@Override
	public SiqNotasResponse getNotasSiq(final SiqNotasRequest request) {
		String query = ConstantesFolio.NOTAS_QUERY + request.getIdentificadorSiq();
		String fields = ConstantesFolio.NOTAS_FIELDS_PARAM;
		SiqNotasResponse response = busquedaSiqNotasClient.getDetalleNotas(query, fields);
		getUsuarioNota(response);
		response.getResult().forEach(objeto -> {
			objeto.setSys_created_on(ConstantesFolio.quitarHora(objeto.getSys_created_on()));
		});
		log.info("Se realizo la consulta de Notas Siqs con exito. " + response.getResult());
		return response;
	}
	
	/*
	 * Obtener el usuario asociado a las notas.
	 * @param response entrada de la lista de notas.
	 */
	private void getUsuarioNota(final SiqNotasResponse response) {
		List<SiqNotas> tempResponse = response.getResult();
		for (SiqNotas nota: tempResponse) {
			String comentario = nota.getNewvalue();
			String usuario = nota.getUser();
			if (!("".equals(usuario)) && usuario.equals(ConstantesFolio.SERVICENOW_USER) && comentario.contains(ConstantesFolio.MIDDLE_DASH)) {
				String[] parts = comentario.split(ConstantesFolio.MIDDLE_DASH);
                nota.setUser(parts[0]);
                nota.setNewvalue(parts[1]);
            } else {
                actualizarUsuario(nota);
            }
		}
	}
	
	/**
	 * Buscar y actualizar el usuario asociado a la nota.
	 * @param nota
	 */
	private void actualizarUsuario(final SiqNotas nota) {
        String usuario = nota.getUser();
        String queryUser = ConstantesFolio.SYSPARAM_QUERY + usuario;
        String fieldsUser = ConstantesFolio.SYSPARAM_FIELDS_USER;
        String valueUser = ConstantesFolio.SYSPARAM_DISPLAY;
        String linkUser = ConstantesFolio.SYSPARAM_EXCLUDE;
        UsuarioNotasResponse responseUsuario = busquedaSiqUserClient.getDetalleUsuario(queryUser, fieldsUser, valueUser, linkUser);
        if (!(responseUsuario.getResult().isEmpty())) {
            nota.setUser(responseUsuario.getResult().get(0).getName());
        } else {
            nota.setUser(nota.getUser());
        }
    }
}