package mx.seg.ipn.aplicacion.nombre.model;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import mx.seg.ipn.aplicacion.utils.ConstantesFolio;

/**
 * Response del tramite Siq.
 */
@Data
@Schema(description = "Modelo de la respuesta de las Siqs")
public class DatosSiqDetalleResponse {
	/** Lista de SIQs. **/
	@Schema(description = "Lista de resultados", example = ConstantesFolio.SIQ_200_NOMBRE)
	private List<DatosSiqDetalle> result;
}