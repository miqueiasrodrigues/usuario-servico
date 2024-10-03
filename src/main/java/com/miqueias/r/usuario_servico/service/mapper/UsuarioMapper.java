package com.miqueias.r.usuario_servico.service.mapper;

import com.miqueias.r.usuario_servico.domain.Usuario;
import com.miqueias.r.usuario_servico.domain.dto.UsuarioCreateDTO;
import com.miqueias.r.usuario_servico.domain.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO toUsuarioDTO(Usuario usuario);
    Usuario toUsuario(UsuarioCreateDTO usuarioCreateDTO);
    Usuario toUsuario(UsuarioDTO usuarioDTO);
}
