package mx.seg.ipn.aplicacion.nombre.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Request del tramite Siq.
 */
@Data
@Schema(description = "Modelo para la busqueda de Siqs por nombre del contratante")
public class DatosSiqRequest {
	/** Lista de polizas a buscar en paquetes de 100. **/
	@Schema(description = "Lista de polizas asociadas a una persona fisica o moral")
	private List<String> polizas;
	/** Ramo de busqueda de SIQs. **/
	@Schema(description = "Ramo de la Siq", example = "A")
    private String ramo;
	/** Fecha de inicio para hacer la busqueda. **/
    @Schema(description = "Fecha de inicio para realizar el filtrado de siqs", example = "03/06/2024")
    private String fechaIncio;
    /** Fecha fin para hacer la busqueda. **/
    @Schema(description = "Fecha de fin para realizar el filtrado de siqs", example = "04/06/2024")
    private String fechaFin;
}