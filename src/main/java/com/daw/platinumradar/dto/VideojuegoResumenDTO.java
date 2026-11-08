package com.daw.platinumradar.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VideojuegoResumenDTO {
    private String codigoRegistro;
    private String titulo;
    private String steamAppId;
    private String estado;
    private Double horasJugadas;
    private Double PorcentajeHistoria;
    private Double precioObjetivo;
    private LocalDate ultimaPartida;
    private Boolean alertaOfertaActiva;
    private List<String> logrosDesbloqueados = new ArrayList<>();
    
}
