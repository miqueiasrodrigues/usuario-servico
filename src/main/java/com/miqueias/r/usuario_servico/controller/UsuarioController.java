package com.miqueias.r.usuario_servico.controller;

import com.miqueias.r.usuario_servico.domain.dto.UsuarioCreateDTO;
import com.miqueias.r.usuario_servico.domain.dto.UsuarioDTO;
import com.miqueias.r.usuario_servico.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl service;

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
            public ResponseEntity<UsuarioDTO> findById(@PathVariable(value = "id") Long id){
        UsuarioDTO usuarioDTO = service.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping(value = "/busca-por-email/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UsuarioDTO> findByEmail(@PathVariable(value = "email") String email){
        UsuarioDTO usuarioDTO = service.findByEmail(email);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        UsuarioDTO usuarioCreatedDTO = service.create(usuarioCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreatedDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioUpdateDTO){
        UsuarioDTO usuarioUpdatedDTO = service.update(usuarioUpdateDTO);
        return ResponseEntity.ok(usuarioUpdatedDTO);

    }

}
