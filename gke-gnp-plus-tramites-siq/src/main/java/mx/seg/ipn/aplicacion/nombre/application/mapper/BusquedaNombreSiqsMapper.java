package mx.seg.ipn.aplicacion.nombre.application.mapper;

import java.util.List;
import java.util.stream.Collectors;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiq;
import mx.seg.ipn.aplicacion.nombre.model.DatosSiqDetalle;
import mx.seg.ipn.aplicacion.utils.ConstantesFolio;

/**
 * Mapper del servicio.
 */
public final class BusquedaNombreSiqsMapper {
	/** Constructor del Mapper. **/
	private BusquedaNombreSiqsMapper() {
	}
	/**
	 * @param siqNombre lista de siqs asociadas a una lista de polizas.
	 * @return el DTO actualizado.
	 */
	public static DatosSiqDetalle mapToDetalleSiqNombre(final DatosSiq siqNombre) {
		String ramoTransformado = ConstantesFolio.RAMO_MAP_TRASFORMACION.getOrDefault(siqNombre.getU_ramo(), siqNombre.getU_ramo());
        return DatosSiqDetalle.builder()
            .folioSIQ(siqNombre.getNumber())
            .clasificacion(siqNombre.getU_clasification())
            .identificadorSiq(siqNombre.getSys_id())
            .ramo(ramoTransformado)
            .asignado(siqNombre.getAssigned_to())
            .estado(siqNombre.getState())
            .descripcion(siqNombre.getShort_description())
            .tipoTramite(siqNombre.getU_clasification())
            .siniestro(siqNombre.getU_siniestro())
            .ordenTrabajo(siqNombre.getU_work_order())
            .fechaCreacion(siqNombre.getOpened_at())
            .fechaCierre(siqNombre.getClosed_at())
            .nombreContratante(siqNombre.getU_full_name())
            .telefonoNotificaciones(siqNombre.getU_notifications_phone())
            .correoNotificaciones(siqNombre.getU_notifications_mail())
            .descripcionCorta(siqNombre.getShort_description())
            .numeroPoliza(siqNombre.getU_policy_number())
            .segmento(siqNombre.getU_segmento())
            .build();
	}
	/**
	 * @param siqNombre lista de siqs asociadas a una lista de polizas.
	 * @return el DTO actualizado.
	 */
	public static List<DatosSiqDetalle> mapToDetalleSiqNombreList(final List<DatosSiq> siqNombre) {
        return siqNombre.stream()
                .map(BusquedaNombreSiqsMapper::mapToDetalleSiqNombre)
                .collect(Collectors.toList());
    }
}