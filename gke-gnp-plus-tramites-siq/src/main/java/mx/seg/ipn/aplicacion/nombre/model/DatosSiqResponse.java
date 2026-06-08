package mx.seg.ipn.aplicacion.nombre.model;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Response del tramite Siq.
 */
@Data
@Schema(description = "Modelo de la respuesta de las Siqs")
public class DatosSiqResponse {
	/** Lista de SIQs. **/
	private List<DatosSiq> result;
}