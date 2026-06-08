package mx.seg.ipn.aplicacion.notas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Request de las notas asociadas al trámite SIQ.
 */
@Data
@Schema(description = "Modelo para la búsqueda de notas asociadas al identificador de la SIQ.")
public class SiqNotasRequest {
	/** Identificador de la SIQ. **/
	@Schema(description = "Identificador de la SIQ", example = "04ba9ce1db560a9039d8d9fcd39619d8")
	private String identificadorSiq;
}