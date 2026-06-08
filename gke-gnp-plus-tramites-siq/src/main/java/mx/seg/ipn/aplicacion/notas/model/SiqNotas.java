package mx.seg.ipn.aplicacion.notas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Modelo de las notas asociadas al trámite SIQ.
 */
@Data
@Schema(description =  "Modelo de las notas asociadas a los Siqs")
public class SiqNotas {
	/** Descripción de la nota asociada a la SIQ. **/
	@Schema(description = "Descripción de la nota", 
			example = "Se le ofreció al cliente una extensión del vehículo.")
	private String newvalue;
	/** Fecha de la nota asociada a la SIQ. **/
	@Schema(description = "Fecha de Creación", example = "24-05-2024")
	private String sys_created_on;
	/** Usuario de la nota asociada a la SIQ. **/
	@Schema(description = "Usuario", example = "Usuario Intergación Buq")
	private String user;
}