package com.daw.platinumradar.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class VideojuegoCreacionDTO {
    @NotBlank(message = "El titulo no puede estar vacío.")
    @Size(min =2, max=100, message = "El titulo debe tener entre 2 y 100 caracteres.")
    private String titulo;
    @NotBlank(message = "El steamApId no puede estar vacío.")
    @Pattern(regexp = "^[0-9]+$",message = "El steamAppId solo permite números")
    private String steamAppId;
    @NotNull(message = "El estado no puede ser nulo")
    private String estado;
    @NotNull(message = "horasJugadas no puede ser nulo")
    @PositiveOrZero(message = "horasJugadas debe ser mayor o igual a cero")
    private Double horasJugadas;
    @NotNull(message = "El porcentaje no debe ser nulo")
    @Min(value = 0, message = "")
    @Max(value = 100, message = "")
    private Double porcentajeHistoria;
    @NotNull(message = "El precio no puede ser nulo")
    @PositiveOrZero(message = "el precio debe ser positivo")
    private Double precioObjetivo;
    @NotNull(message = "ultima partida no puede ser null")
    @PastOrPresent(message = "la ultima partida solo puede ser registrada en una fecha anterior o el presente")
    private LocalDate ultimaPartida;
    @NotBlank(message = "el email no puede estar en blanco")
    @Email(message = "el email tiene que tener formato email")
    private String emailUsuario;
    @NotNull(message = "alertaOferta no puede ser nulo")
    private Boolean alertaOfertaActiva;
    private List<String> logrosDesbloqueados = new ArrayList<>();
}
