package com.miqueias.r.usuario_servico.service;

import com.miqueias.r.usuario_servico.domain.dto.UsuarioCreateDTO;
import com.miqueias.r.usuario_servico.domain.dto.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO findById(Long id);
    UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO);
    UsuarioDTO update(UsuarioDTO usuarioDTO);
    UsuarioDTO findByEmail(String email);
}
