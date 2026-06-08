package mx.seg.ipn.aplicacion.seguridad.infrastructure.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

//import jakarta.persistence.Column;
//import jakarta.persistence.EntityListeners;
//import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity implements Serializable {
    /**
     * Numero de version para la serializacion de esta clase.
     */
    private static final long serialVersionUID = 1922432977184716961L;

    /** Longitud del campo de Usuario de auditor&iacute;a. */
    private static final int LENGTH_USR_AUDIT = 255;

    /**
     * Usuario al momento de la inserción del registro.
     */
    @Column(name = "usr_alta", nullable = false, length = LENGTH_USR_AUDIT)
    private String usrAlta;

    /**
     * Usuario al momento de una inserción o actualización al registro.
     */
    @Column(name = "usrModifica", nullable = false, length = LENGTH_USR_AUDIT)
    private String usrModifica;

    /**
     * Timestamp del sistema al momento de la inserción del registro.
     */
    @Column(name = "fch_alta", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fchAlta;

    /**
     * Timestamp del sistema al momento de una inserción o actualización al registro.
     */
    @Column(name = "fch_modifica")
    @UpdateTimestamp
    private LocalDateTime fchModifica;

}

