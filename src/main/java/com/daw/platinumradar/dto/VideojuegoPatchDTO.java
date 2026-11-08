package com.daw.platinumradar.dto;


import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VideojuegoPatchDTO {

    @Size(min =2, max=100, message = "El titulo debe tener entre 2 y 100 caracteres.")
    private String titulo;

    @Pattern(regexp = "^[0-9]+$",message = "El steamAppId solo permite números")
    private String steamAppId;

    private String estado;

    @PositiveOrZero(message = "horasJugadas debe ser mayor o igual a cero")
    private Double horasJugadas;

    @Min(value = 0, message = "")
    @Max(value = 100, message = "")
    private Double porcentajeHistoria;

    @PositiveOrZero(message = "el precio debe ser positivo")
    private Double precioObjetivo;

    @PastOrPresent(message = "la ultima partida solo puede ser registrada en una fecha anterior o el presente")
    private LocalDate ultimaPartida;

    @Email(message = "el email tiene que tener formato email")
    private String emailUsuario;

    private Boolean alertaOfertaActiva;
    private List<String> logrosDesbloqueados = new ArrayList<>();
}
