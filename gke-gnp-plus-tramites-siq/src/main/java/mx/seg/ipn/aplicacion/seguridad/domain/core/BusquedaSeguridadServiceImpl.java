package mx.seg.ipn.aplicacion.seguridad.domain.core;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.seg.ipn.aplicacion.nombre.application.mapper.BusquedaNombreSiqsMapper;
import mx.seg.ipn.aplicacion.nombre.infrastructure.BusquedaSiqsClient;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiq;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiqDetalle;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiqDetalleResponse;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiqRequest;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiqResponse;
import mx.seg.ipn.aplicacion.seguridad.domain.incoming.BusquedaSeguridadLogic;
import mx.seg.ipn.aplicacion.utils.ConstantesFolio;

/**
 * Implementación de los metodos para la consulta de siqs por nombre del contratante.
 */
@Service
@Slf4j
public class BusquedaSeguridadServiceImpl implements BusquedaSeguridadLogic {
	/** Consulta al servicio externo. **/
	@Autowired
	private BusquedaSiqsClient busquedaSiqsClient;
	
	/**
	 * 
	 * @param request datos de entrada para la busqueda.
	 * @return siqs asociados al nombre del contratante.
	 */
	@Override
	public DatosSiqDetalleResponse getSiqsNombre(final DatosSiqRequest request) {
		DatosSiqDetalleResponse  detalleSiqResponse = new DatosSiqDetalleResponse();
		if (request.getPolizas().isEmpty()) {
			log.info("La lista de polizas esta vacia");
		} else {
			StringBuilder query = new StringBuilder();
			for (String item:request.getPolizas()) {
				query.append(ConstantesFolio.SYSPARAM_NUMBERPOLICY).append(item).append(ConstantesFolio.CONDICIONAL_POLIZA);
			}
			request.setFechaIncio((request.getFechaIncio() != null && request.getFechaIncio().isEmpty()) ? null : request.getFechaIncio());
	    	request.setFechaFin((request.getFechaFin() != null && request.getFechaFin().isEmpty()) ? null : request.getFechaFin());
			query.append(ConstantesFolio.RAMO_MAP.get(request.getRamo()));
			String value = ConstantesFolio.SYSPARAM_DISPLAY_VALUE;
			String field = ConstantesFolio.FIELDS_PARAM;
			String links = ConstantesFolio.SYSPARAM_LINK;
			DatosSiqResponse response = new DatosSiqResponse();
			response = busquedaSiqsClient.getDetalelleNombre(query.toString(), value, field, links);
			response.getResult().forEach(objeto -> {
	                objeto.setOpened_at(ConstantesFolio.quitarHora(objeto.getOpened_at()));
	                objeto.setClosed_at(ConstantesFolio.quitarHora(objeto.getClosed_at()));
	        });
			response.setResult(filtrarFechas(response.getResult(), request));
			List<DatosSiqDetalle> mappedList = BusquedaNombreSiqsMapper.mapToDetalleSiqNombreList(response.getResult());
	        detalleSiqResponse.setResult(mappedList);
	        log.info("Se realizo la consulta de SIQS con exito. " + detalleSiqResponse);
		} 
		return detalleSiqResponse;
	}
	
	/**
    *
    * @param lista respuesta cuando se consulta service now.
    * @param request parametros para el filtrado.
    * @return la lista de siqs filtrada por fechas.
    */
	public List<DatosSiq> filtrarFechas(final List<DatosSiq> lista, final DatosSiqRequest request) {
       return lista.stream()
               .filter(obj -> {
                   String fecha = obj.getOpened_at();
                   boolean cumpleInicio = request.getFechaIncio() == null || fecha.compareTo(request.getFechaIncio()) >= 0;
                   boolean cumpleFin = request.getFechaFin() == null || fecha.compareTo(request.getFechaFin()) <= 0;
                   return (request.getFechaIncio() == null || cumpleInicio) && (request.getFechaFin() == null || cumpleFin);
               })
               .collect(Collectors.toList());
	}
}