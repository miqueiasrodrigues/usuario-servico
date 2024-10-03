package com.miqueias.r.usuario_servico.domain.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class UsuarioCreateDTO implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private String sobrenome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioCreateDTO that = (UsuarioCreateDTO) o;
        return Objects.equals(nome, that.nome) && Objects.equals(sobrenome, that.sobrenome) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, email);
    }
}

