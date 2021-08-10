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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "seg_usuario_perfil")
public class SegUsuarioPerfil implements Serializable {

    @EmbeddedId
    protected SegUsuarioPerfilPK pk;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    
    @Column(name = "por_omision", nullable = false, length = 1)
    private String porOmision;
    
    @JoinColumn(name = "cod_perfil", referencedColumnName = "cod_perfil", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegPerfil segPerfil;
    
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegUsuario segUsuario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segPerfil")
    private List<SegPerfil> perfiles;

}
