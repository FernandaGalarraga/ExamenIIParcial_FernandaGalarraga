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
package ec.edu.espe.distribuidas.galarraga.dao;

import ec.edu.espe.distribuidas.galarraga.model.SegUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegUsuarioRepository extends JpaRepository<SegUsuario, String>{
    
}
