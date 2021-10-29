package com.romulomotta.checkpoint.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "login")
    @NotEmpty(message = "Campo de Usuário precisa ser preenchido.")
    private String username;

    @Column(name = "senha")
    @NotEmpty(message = "Campo de Senha precisa ser preenchido.")
    private String password;
}
