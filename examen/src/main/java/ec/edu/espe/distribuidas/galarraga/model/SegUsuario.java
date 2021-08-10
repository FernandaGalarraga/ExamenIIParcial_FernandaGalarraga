/*
 * Copyright (c) 2021 Distrbuidas.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Fernanda Galárraga
 */
package ec.edu.espe.distribuidas.galarraga.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "seg_usuario", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"identificacion"})})
public class SegUsuario implements Serializable {

    @Id
    @Column(name = "cod_usuario", nullable = false, length = 30)
    private String codUsuario;
    
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    
    @Column(name = "identificacion", nullable = false, length = 30)
    private String identificacion;
    
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    
    @Column(name = "nro_intentos_fallidos", nullable = false)
    private int nroIntentosFallidos;
    
    @Column(name = "fecha_ultima_sesion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaSesion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario")
    private List<SegUsuarioPerfil> segUsuarioPerfilList;

}
