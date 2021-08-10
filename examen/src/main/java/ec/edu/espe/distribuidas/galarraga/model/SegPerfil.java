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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "seg_perfil")
public class SegPerfil implements Serializable {

    @Id
    @Column(name = "cod_perfil", nullable = false, length = 8)
    private String codigo;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    
    

}
