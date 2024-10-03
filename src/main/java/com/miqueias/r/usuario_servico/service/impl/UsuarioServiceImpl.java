package com.miqueias.r.usuario_servico.service.impl;

import com.miqueias.r.usuario_servico.domain.Usuario;
import com.miqueias.r.usuario_servico.domain.dto.UsuarioCreateDTO;
import com.miqueias.r.usuario_servico.domain.dto.UsuarioDTO;
import com.miqueias.r.usuario_servico.exception.EmailAlreadyInUseException;
import com.miqueias.r.usuario_servico.exception.ResourceNotFoundException;
import com.miqueias.r.usuario_servico.repository.UsuarioRepository;
import com.miqueias.r.usuario_servico.service.UsuarioService;
import com.miqueias.r.usuario_servico.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    private final UsuarioMapper mapper = UsuarioMapper.INSTANCE;

    @Override
    public UsuarioDTO findById(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Usuário não encontrado.")
        );
        return mapper.toUsuarioDTO(usuario);
    }

    @Override
    public UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO) {

        Optional<Usuario> usuarioExists = repository.findByEmail(mapper.toUsuario(usuarioCreateDTO).getEmail());

        if(usuarioExists.isPresent()){
            throw new EmailAlreadyInUseException("E-mail já existente.");
        }

        Usuario usuarioCreate = repository.save(mapper.toUsuario(usuarioCreateDTO));

        return mapper.toUsuarioDTO(usuarioCreate);
    }

    @Override
    public UsuarioDTO update(UsuarioDTO usuarioUpdateDTO) {

        Usuario usuario = repository.findById(mapper.toUsuario(usuarioUpdateDTO).getId()).orElseThrow(
                () -> new ResourceNotFoundException("Usuário não encontrado.")
        );

        Optional<Usuario> usuarioExists = repository.findByEmail(mapper.toUsuario(usuarioUpdateDTO).getEmail());

        if(usuarioExists.isPresent() && !usuarioExists.get().getId().equals(mapper.toUsuario(usuarioUpdateDTO).getId())){
            throw new EmailAlreadyInUseException("E-mail já existente.");
        }

        usuario.setNome(mapper.toUsuario(usuarioUpdateDTO).getNome());
        usuario.setSobrenome(mapper.toUsuario(usuarioUpdateDTO).getSobrenome());
        usuario.setEmail(mapper.toUsuario(usuarioUpdateDTO).getEmail());

        Usuario usuarioUpdate = repository.save(usuario);

        return mapper.toUsuarioDTO(usuarioUpdate);
    }

    @Override
    public UsuarioDTO findByEmail(String email) {
        Usuario usuario = repository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Usuário não encontrado.")
        );
        return mapper.toUsuarioDTO(usuario);
    }
}
