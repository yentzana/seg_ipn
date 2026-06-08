package mx.seg.ipn.aplicacion.notas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Modelo del usuario asociado a la nota.
 */
@Data
@Schema(description =  "Modelo del usuario asociado a la Nota")
public class UsuarioNotas {
	/** Usuario de la Nota asociadas a la Siq. **/
	@Schema(description = "Usuario", example = "Usuario Intergación Buq")
	private String name;
}