package com.romulomotta.checkpoint.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "Campo (Título) não pode ser vazio.")
    private String title;

    @Column(nullable = false, length = 4)
    @NotNull(message = "Campo (Episódio) não pode ser nulo.")
    private Integer episode;

    @Column(nullable = true, length = 4)
    private Integer season;
}
