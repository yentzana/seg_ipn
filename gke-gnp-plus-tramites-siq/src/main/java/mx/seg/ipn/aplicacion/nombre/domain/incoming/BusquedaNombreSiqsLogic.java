package mx.seg.ipn.aplicacion.nombre.domain.incoming;

import mx.seg.ipn.aplicacion.nombre.model.DatosSiqDetalleResponse;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiqRequest;

/**
 * Interfaz para la consulta de siqs por nombre del contratante.
 */
public interface BusquedaNombreSiqsLogic {
	/**
	 * 
	 * @param request datos de entrada para la busqueda.
	 * @return siqs asociados al nombre del contratante.
	 */
	DatosSiqDetalleResponse getSiqsNombre(DatosSiqRequest request);
}