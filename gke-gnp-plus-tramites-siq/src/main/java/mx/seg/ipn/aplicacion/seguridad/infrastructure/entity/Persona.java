package mx.seg.ipn.aplicacion.seguridad.infrastructure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
//import jakarta.persistence.Column;
//import jakarta.persistence.EmbeddedId;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Persona")
public class Persona extends AuditEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4659269298680251786L;


//    @EmbeddedId
	@Id
	@Column(name = "id_persona")
    private String id;

//    @Column(name = "genero")
//    private String genero;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido_paterno")
    private String ap;
    
    @Column(name = "apellido_materno")
    private String am;
    
//    @Column(name = "cve_genero")
    @ManyToOne
    @JoinColumn(name = "cve_genero")
    private CatGenero cve_genero;
    
//    @Column(name = "NOMBRE_ARCHIVO")
//    private String nombreArchivo;
//
//    @Column(name = "ESTATUS")
//    private Integer estatus;

}
