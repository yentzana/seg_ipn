package mx.seg.ipn.aplicacion.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ConstantesFolio {
	
	private ConstantesFolio() {		
	}
	/** Parametro para buscar por numero de siniestro. **/
	public static final String SYSPARAM_NUMSINIESTRO = "u_siniestro=";
	
    /** Atributos a devolver en la consulta de SIQS asocaidos a una poliza desde service now. **/
    public static final String SYSPARAM_FIELDS = "number,u_clasification,state,"
    		+ "opened_at,sys_id,u_ramo,short_description,u_clasification,u_siniestro,assigned_to,"
    		+ "u_work_order,closed_at,u_full_name,u_notifications_mail,short_description,u_policy_number,u_notifications_phone";
    /** Atributos a devolver en la consulta de SIQS asocaidos a una poliza desde service now. **/
    public static final String SYSPARAM_LINK = "true";
    /** Parametro para la traduccion del estatus. **/
    public static final String SYSPARAM_DISPLAY_VALUE = "true";
    /** Parametro para buscar por numero de poliza. **/
    public static final String SYSPARAM_NUMBERPOLICY = "u_policy_number=";
    /** Codigo 200. **/
    public static final String CODIGO_EXITOSO = "200";
    public static final String SIQ_200 = "{\r\n"
    		+ "  \"folioSIQ\": \"SIQ0164921\",\r\n"
    		+ "  \"clasificacion\": \"Siniestros\",\r\n"
    		+ "  \"numero\": \"4f6329f01b3f749016bcc802604bcb09\",\r\n"
    		+ "  \"ramo\": \"Autos\",\r\n"
    		+ "  \"asignado\": \"Jose Alfonso Reyes Rodriguez\",\r\n"
    		+ "  \"estado\": \"Cerrado\",\r\n"
    		+ "  \"descripcion\": \"Inconformidad con valuacion\",\r\n"
    		+ "  \"tipoTramite\": \"Siniestros\",\r\n"
    		+ "  \"siniestro\": \"0118653096\",\r\n"
    		+ "  \"ordenTrabajo\": \"OT\",\r\n"
    		+ "  \"fechaCreacion\": \"2021-11-11 00:42:03\",\r\n"
    		+ "  \"fechaCierre\": \"2021-11-11 00:42:03\",\r\n"
    		+ "  \"nombreContratante\": \"KZ MEDICAL S. DE R.L. DE C.V.\",\r\n"
    		+ "  \"telefonoNotificaciones\": \"5527946258\",\r\n"
    		+ "  \"correoNotificaciones\": \"elielguerrero2506@gmail.com.mx\",\r\n"
    		+ "  \"descripcionCorta\": \"Inconformidad con valuacion\",\r\n"
    		+ "  \"numeroPoliza\": \"00000458978186\"\r\n"
    		+ "}";

    /** Codigo de error 500. **/
    public static final String CODIGO_ERROR_INISPERADO = "500";
    /** Mensaje de error codigo 500. **/
    public static final String ERROR_500 = "{\n"
            + "    \"error\": \"internal_server_error\",\n"
            + "    \"mensaje\": \"Ocurrió un problema inesperado\",\n"
            + "    \"timestamp\": 1689353951404\n"
            + "}";
	public static final String SIQ_POLIZA_200 = "{\r\n"
			+ "  \"result\": [\r\n"
			+ "    {\r\n"
			+ "      \"folioSIQ\": \"SIQ0164921\",\r\n"
			+ "      \"clasificacion\": \"Siniestros\",\r\n"
			+ "      \"identificadorSiq\": \"4f6329f01b3f749016bcc802604bcb09\",\r\n"
			+ "      \"ramo\": \"Autos\",\r\n"
			+ "      \"asignado\": \"Jose Alfonso Reyes Rodriguez\",\r\n"
			+ "      \"estado\": \"Closed\",\r\n"
			+ "      \"descripcion\": \"Inconformidad con valuacion \",\r\n"
			+ "      \"tipoTramite\": \"Siniestros\",\r\n"
			+ "      \"siniestro\": \"0118653096\",\r\n"
			+ "      \"ordenTrabajo\": \"\",\r\n"
			+ "      \"fechaCreacion\": \"2021-11-10\",\r\n"
			+ "      \"fechaCierre\": \"2021-11-16\",\r\n"
			+ "      \"nombreContratante\": \"DKZ MEDICAL S. DE R.L. DE C.V.\",\r\n"
			+ "      \"telefonoNotificaciones\": \"5527946258\",\r\n"
			+ "      \"correoNotificaciones\": \"elielguerrero2506@gmail.com.mx\",\r\n"
			+ "      \"descripcionCorta\": \"Inconformidad con valuacion \",\r\n"
			+ "      \"numeroPoliza\": \"00000458978186\"\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";
	public static final String FORMATO_FECHA_HORA = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMATO_FECHA = "yyyy-MM-dd";
	
	public static String quitarHora(final String fechaConHora) {
	    try {
	        SimpleDateFormat formatoConHora = new SimpleDateFormat(ConstantesFolio.FORMATO_FECHA_HORA);
	        SimpleDateFormat formatoSinHora = new SimpleDateFormat(ConstantesFolio.FORMATO_FECHA);
	        Date fecha = formatoConHora.parse(fechaConHora);
	        String fechaFormateada = formatoSinHora.format(fecha);

	        return fechaFormateada;
	    } catch (ParseException e) {
	        log.error(e.getMessage());
	        return null;
	    }
	}
	
	/** Asociasión de ramos con sus descripciones. **/
	public static final Map<String, String> RAMO_MAP = new HashMap<>();
    static {
        RAMO_MAP.put("gmm", "^u_ramo=Gastos Médicos");
        RAMO_MAP.put("vida", "^u_ramo=Vida");
        RAMO_MAP.put("autos", "^u_ramo=Autos");
        RAMO_MAP.put("danios", "^u_ramo=Daños");
        RAMO_MAP.put("todos", "");
    }
    
    /** Asociasión de ramos con sus descripciones. **/
	public static final Map<String, String> RAMO_MAP_TRASFORMACION = new HashMap<>();
    static {
        RAMO_MAP_TRASFORMACION.put("Gastos Médicos", "gmm");
        RAMO_MAP_TRASFORMACION.put("Vida", "vida");
        RAMO_MAP_TRASFORMACION.put("Autos", "autos");
        RAMO_MAP_TRASFORMACION.put("Daños", "danios");
    }
    
    /** Nombre completo de los Siqs. **/
    public static final String CONDICIONAL_POLIZA = "^OR";
    /** Parámetros de campos de los Siqs. **/
    public static final String FIELDS_PARAM = "u_segmento,number,u_clasification,state,"
    		+ "opened_at,sys_id,u_ramo,short_description,u_clasification,u_siniestro,assigned_to,"
    		+ "u_work_order,closed_at,u_full_name,u_notifications_mail,short_description,u_policy_number,u_notifications_phone";
    /** Mensaje del codigo 200. **/
    public static final String SIQ_200_NOMBRE = "{\r\n"
    		+ "  \"result\": [\r\n"
    		+ "    {\r\n"
    		+ "      \"folioSIQ\": \"SIQ0003069\",\r\n"
    		+ "      \"clasificacion\": \"Contratación\",\r\n"
    		+ "      \"identificadorSiq\": \"2d9f698bdb618c10c9614b9f299619bb\",\r\n"
    		+ "      \"ramo\": \"danios\",\r\n"
    		+ "      \"asignado\": \"Celia Alvarez Rodea\",\r\n"
    		+ "      \"estado\": \"Closed\",\r\n"
    		+ "      \"descripcion\": \"CAMBIO DE FORMA DE PAGO\",\r\n"
    		+ "      \"tipoTramite\": \"Contratación\",\r\n"
    		+ "      \"siniestro\": \"\",\r\n"
    		+ "      \"ordenTrabajo\": \"NA\",\r\n"
    		+ "      \"fechaCreacion\": \"2019-12-10\",\r\n"
    		+ "      \"fechaCierre\": \"2019-12-10\",\r\n"
    		+ "      \"nombreContratante\": \"juan jose rodriguez delgado\",\r\n"
    		+ "      \"telefonoNotificaciones\": \"6059\",\r\n"
    		+ "      \"correoNotificaciones\": \"juanjose.rodriguez@gnp.com.mx\",\r\n"
    		+ "      \"descripcionCorta\": \"CAMBIO DE FORMA DE PAGO\",\r\n"
    		+ "      \"numeroPoliza\": \"00000360619993\",\r\n"
    		+ "      \"segmento\": \"LC\"\r\n"
    		+ "    }\r\n"
    		+ "  ]\r\n"
    		+ "}";
    
    /** Tipo de nota e identificador SIQ. **/
    public static final String NOTAS_QUERY = "fieldname=work_notes^documentkey=";
    /** Parámetros de campos de las Notas SIQ. **/
    public static final String NOTAS_FIELDS_PARAM = "user,newvalue,sys_created_on";
    /** Mensaje del código 200 de Notas. **/
    public static final String SIQ_NOTAS = "{\r\n"
    		+ "  \"result\": [\r\n"
    		+ "    {\r\n"
    		+ "      \"newvalue\": \"Se le ofreció al cliente una extensión del vehículo.\",\r\n"
    		+ "      \"sys_created_on\": \"2024-05-24\",\r\n"
    		+ "      \"user\": \"Usuario Intergación Buq\"\r\n"
    		+ "    }\r\n"
    		+ "  ]\r\n"
    		+ "}";
    /** Separador para formatear la nota y el usuario. **/
    public static final String MIDDLE_DASH = " - ";
    /** Nombre de usuario para autenticación en el servicio REST de ServiceNow. **/
    public static final String SERVICENOW_USER = "buq.rest";
    /** Parámetro utilizado para consultar registros por nombre de usuario en ServiceNow. **/
    public static final String SYSPARAM_QUERY = "user_name=";
    /** Campos que se deben recuperar de los registros consultados en ServiceNow. **/
    public static final String SYSPARAM_FIELDS_USER = "name";
    /** Indica si se deben mostrar los registros consultados en ServiceNow. **/
    public static final String SYSPARAM_DISPLAY = "true";
    /** Indica si se deben excluir ciertos registros en las consultas a ServiceNow. **/
    public static final String SYSPARAM_EXCLUDE = "true";
}