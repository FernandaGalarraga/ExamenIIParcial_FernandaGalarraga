/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.galarraga.transform;

import ec.edu.espe.distribuidas.galarraga.dto.SegUsuarioPerfilRS;
import ec.edu.espe.distribuidas.galarraga.model.SegUsuarioPerfil;


public class SegUsuarioPerfilRSTransform {
    public static SegUsuarioPerfilRS buildUsuarioPerfilRS(SegUsuarioPerfil usuarioPerfil){
        return SegUsuarioPerfilRS.builder()
                .nombreUsuario(usuarioPerfil.getSegUsuario().getNombre())
                .identificacion(usuarioPerfil.getSegUsuario().getIdentificacion())
                .nombrePerfil(usuarioPerfil.getSegPerfil().getNombre())
                .estado(usuarioPerfil.getEstado())
                .build();
    }
}
