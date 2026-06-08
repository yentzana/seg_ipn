package mx.seg.ipn.aplicacion.seguridad.infrastructure.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cat_genero")
public class CatGenero extends AuditEntity implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//    @EmbeddedId
	@Id
	@Column(name = "cve_genero")
    private String id;

    @Column(name = "genero")
    private String genero;

//    @Column(name = "NOMBRE_ARCHIVO")
//    private String nombreArchivo;
//
//    @Column(name = "ESTATUS")
//    private Integer estatus;

}
