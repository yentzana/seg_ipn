package mx.seg.ipn.aplicacion.nombre.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Modelo para los atributos para la respuesta de Siqs.")
public class DatosSiqDetalle {
	@Schema(description = "Folio del Siq", example = "SIQ0164921")
	private String folioSIQ;
	@Schema(description = "Clasificación", example = "Siniestros")
	private String clasificacion;
	@Schema(description = "Identificador unico del siq", example = "4f6329f01b3f749016bcc802604bcb09")
	private String identificadorSiq;
	@Schema(description = "Ramo del negocio", example = "Autos")
	private String ramo;
	@Schema(description = "Persona asignado", example = "Jose Alfonso Reyes Rodriguez")
	private String asignado;
	@Schema(description = "Estado", example = "Cerrado")
	private String estado;
	@Schema(description = "Descripción", example = "Inconformidad con valuacion")
	private String descripcion;
	@Schema(description = "Tipo de tramite", example = "Siniestros")
	private String tipoTramite;
	@Schema(description = "Número de siniestro", example = "0118653096")
	private String siniestro;
	@Schema(description = "Orden de trabajo", example = "OT")
	private String ordenTrabajo;
	@Schema(description = "Fecha de creación", example = "2021-11-11 00:42:03")
	private String fechaCreacion;
	@Schema(description = "Fecha de cierre", example = "2021-11-11 00:42:03")
	private String fechaCierre;
	@Schema(description = "Nombre del contratante", example = "KZ MEDICAL S. DE R.L. DE C.V.")
	private String nombreContratante;
	@Schema(description = "Telefono de notificación", example = "5527946258")
	private String telefonoNotificaciones;
	@Schema(description = "Correo de notificación", example = "elielguerrero2506@gmail.com.mx")
	private String correoNotificaciones;
	@Schema(description = "Descripción corta", example = "Inconformidad con valuacion")
	private String descripcionCorta;
	@Schema(description = "Número de póliza", example = "00000458978186")
	private String numeroPoliza;
	@Schema(description = "Segmento asociado", example = "LP")
	private String segmento;
}