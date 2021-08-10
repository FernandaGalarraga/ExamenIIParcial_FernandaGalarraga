/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.galarraga.service;

import ec.edu.espe.distribuidas.galarraga.dao.SegPerfilRepository;
import ec.edu.espe.distribuidas.galarraga.dao.SegUsuarioPerfilRepository;
import ec.edu.espe.distribuidas.galarraga.dao.SegUsuarioRepository;
import ec.edu.espe.distribuidas.galarraga.exception.CreateException;
import ec.edu.espe.distribuidas.galarraga.model.SegPerfil;
import ec.edu.espe.distribuidas.galarraga.model.SegUsuario;
import ec.edu.espe.distribuidas.galarraga.model.SegUsuarioPerfil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SegUsuarioPerfilService {

    private final SegUsuarioPerfilRepository usuarioPerfilRepo;
    private final SegUsuarioRepository usuarioRepo;
    private final SegPerfilRepository perfilRepo;

    public SegUsuarioPerfilService(SegUsuarioPerfilRepository usuarioPerfilRepo, SegUsuarioRepository usuarioRepo, SegPerfilRepository perfilRepo) {
        this.usuarioPerfilRepo = usuarioPerfilRepo;
        this.usuarioRepo = usuarioRepo;
        this.perfilRepo = perfilRepo;
    }
    


    public List<SegUsuarioPerfil> obtenerPerfiles(String estado) {
        return this.usuarioPerfilRepo.findByEstado(estado);
    }

    @Transactional
    public void insertarPerfilUsuario(List<SegUsuarioPerfil> perfiles) {

        for (SegUsuarioPerfil perfil : perfiles) {
            Optional<SegPerfil> perfilOpt=this.perfilRepo.findById(perfil.getPk().getCodigoPerfil());
            Optional<SegUsuario> usuarioOpt=this.usuarioRepo.findById(perfil.getPk().getCodigoUsuario());
            Optional<SegUsuarioPerfil> usuarioPerfilOpt = this.usuarioPerfilRepo.findById(perfil.getPk());
            if (!usuarioPerfilOpt.isPresent()) {
                perfil.setSegUsuario(usuarioOpt.get());
                perfil.setSegPerfil(perfilOpt.get());
            } else {
                throw new CreateException("Este usuario ya tiene creado el perfil:" + perfil.getSegPerfil().getNombre());
            }
        }
    }

}
