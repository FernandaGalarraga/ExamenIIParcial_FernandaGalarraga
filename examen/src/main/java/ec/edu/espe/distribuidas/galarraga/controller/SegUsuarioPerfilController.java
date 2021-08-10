/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.galarraga.controller;

import ec.edu.espe.distribuidas.galarraga.dto.SegUsuarioPerfilRS;
import ec.edu.espe.distribuidas.galarraga.model.SegUsuarioPerfil;
import ec.edu.espe.distribuidas.galarraga.service.SegUsuarioPerfilService;
import ec.edu.espe.distribuidas.galarraga.transform.SegUsuarioPerfilRSTransform;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/perfil")
public class SegUsuarioPerfilController {
    private final SegUsuarioPerfilService service;

    public SegUsuarioPerfilController(SegUsuarioPerfilService usuarioPerfilService) {
        this.service = usuarioPerfilService;
    }
    
    @ApiOperation(value = "Listar perfiles",
            notes = "Lista completa de perfiles activos")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK. perfiles se obtiene correctamente"),
        @ApiResponse(code = 400, message = "Bad Request. No se encontro el perfil"),
        @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping
    public ResponseEntity obtenerActivos() {
        try{
            log.info("Va a recuperar los perfile con estado activo");
        List<SegUsuarioPerfil> perfiles = this.service.obtenerPerfiles("ACT");
        List<SegUsuarioPerfilRS> perfilesRS = new ArrayList<>();
        perfiles.forEach(t -> {
                perfilesRS.add(SegUsuarioPerfilRSTransform.buildUsuarioPerfilRS(t));
            });
            return ResponseEntity.ok(perfilesRS);
        }catch (Exception e){
            log.error("Ocurrio un error al listar los perfiles. {} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @ApiOperation(value = "Crear perfiles",
            notes = "Crear perfiles de seguridad")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK. Los perfiles se crearon correctamente"),
        @ApiResponse(code = 400, message = "Bad Request. No se pudo guardar la identificacion"),
        @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PostMapping
    public ResponseEntity crearPerfiles(@RequestBody SegUsuarioPerfil request) {
        try {
            
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ocurrio un error al crear la identificacion. {} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
