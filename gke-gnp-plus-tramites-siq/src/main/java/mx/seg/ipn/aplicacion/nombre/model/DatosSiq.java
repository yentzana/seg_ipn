package mx.seg.ipn.aplicacion.nombre.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Modelo del tramite Siq.
 */
@Data
@Schema(description = "Modelo de los elementos de la Siq")
public class DatosSiq {
	/** Valor del folio Siq. **/
	@Schema(description = "Folio de la siq", example = "SIQ0068122")
	private String number;
	/** Clasificacion de la Siq. **/
	@Schema(description = "Clasificación de la siq", example = "Siniestros")
	private String u_clasification;
	/** Valor de la poliza asociada al Siq. **/
	@Schema(description = "Número de póliza", example = "00000363397498")
	private String u_policy_number;
	/** Segmento de la Siq. **/
	@Schema(description = "Segmento asociado", example = "LP")
	private String u_segmento;
	/** Ramo que pertenece a la Siq. **/
	@Schema(description = "Ramo asociado", example = "Autos")
	private String u_ramo;
	/** Estatus del folio Siq. **/
	@Schema(description = "Estatus de la siq", example = "Closed")
	private String state;
	/** Fecha de creacion de la Siq. **/
	@Schema(description = "Fecha de creación de la siq", example = "19-10-2020")
	private String opened_at;
	/** Identificador Siq. **/
    @Schema(description = "Identificador unico del siq", example = "4f6329f01b3f749016bcc802604bcb09")
    private String sys_id;
    /** Descripción de la Siq. **/
    @Schema(description = "Descripción", example = "Inconformidad con valuacion")
    private String short_description;
    /** Siniestro asociado al Siq. **/
    @Schema(description = "Número de siniestro", example = "0118653096")
    private String u_siniestro;
    /** Persona asignada. **/
    @Schema(description = "Persona asignado", example = "Jose Alfonso Reyes Rodriguez")
    private String assigned_to;
    /** Orden de Trabajo. **/
    @Schema(description = "Orden de trabajo", example = "OT")
    private String u_work_order;
    /** Fecha de Cierre del Siq. **/
    @Schema(description = "Fecha de cierre del Siq", example = "2021-11-11 00:42:03")
    private String closed_at;
    /** Nombre del Contratante. **/
    @Schema(description = "Nombre del contratante", example = "KZ MEDICAL S. DE R.L. DE C.V.")
    private String u_full_name;
    /** Telefono del Contratante. **/
    @Schema(description = "Telefono de notificación", example = "5527946258")
	private String u_notifications_phone;
    /** Correo de notificacion. **/
	@Schema(description = "Correo de notificación", example = "elielguerrero2506@gmail.com.mx")
	private String u_notifications_mail;
}