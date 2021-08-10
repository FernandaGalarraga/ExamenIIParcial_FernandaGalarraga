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
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SegUsuarioPerfilPK implements Serializable {

    @Column(name = "cod_usuario", nullable = false, length = 30)
    private String codigoUsuario;
    
    @Column(name = "cod_perfil", nullable = false, length = 8)
    private String codigoPerfil;

}
