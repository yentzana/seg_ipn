package mx.seg.ipn.aplicacion.notas.model;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import mx.seg.ipn.aplicacion.utils.ConstantesFolio;

/**
 * Response de las notas asociadas al trámite SIQ.
 */
@Data
@Schema(description = "Modelo de las respuestas de las notas")
public class SiqNotasResponse {
	/** Lista de notas por identificador de la SIQ. **/
	@Schema(description = "Lista de resultados", example = ConstantesFolio.SIQ_NOTAS)
	private List<SiqNotas> result;
}