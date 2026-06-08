package mx.seg.ipn.aplicacion.notas.domain.incoming;

import mx.seg.ipn.aplicacion.notas.model.SiqNotasRequest;
import mx.seg.ipn.aplicacion.notas.model.SiqNotasResponse;

/**
 * Interfaz para la consulta de notas asociadas a un identificador de SiQ.
 */
public interface BusquedaSiqNotasLogic {
	/**
	 * 
	 * @param request datos de entrada para la búsqueda.
	 * @return notas asociadas a un identificador de SIQ.
	 */
	SiqNotasResponse getNotasSiq(SiqNotasRequest request);
}