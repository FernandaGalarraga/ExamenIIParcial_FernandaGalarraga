/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.galarraga.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SegUsuarioPerfilRS {
    private String nombreUsuario;
    private String identificacion;
    private String nombrePerfil;
    private String estado;
    private String porOmision;
}
