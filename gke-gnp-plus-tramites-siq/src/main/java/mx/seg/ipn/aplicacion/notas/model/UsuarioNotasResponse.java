package mx.seg.ipn.aplicacion.notas.model;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import mx.seg.ipn.aplicacion.utils.ConstantesFolio;

/**
 * Response del usuario asociado a la nota.
 */
@Data
@Schema(description = "Modelo de las respuestas del usuario asociado a una nota")
public class UsuarioNotasResponse {
	/** Lista de usuarios asociados a la nota. **/
	@Schema(description = "Lista de resultados", example = ConstantesFolio.SIQ_NOTAS)
	private List<UsuarioNotas> result;
}