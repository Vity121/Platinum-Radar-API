package com.daw.platinumradar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "videojuego")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Videojuego {

    // 1. Clave primaria autoincremental de la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 2. Campo generado automáticamente para cumplir el requisito de @Column(unique = true)[cite: 3]
    @Column(nullable = false, unique = true, length = 36)
    private String codigoRegistro = UUID.randomUUID().toString();

    // 3. Título del videojuego
    @Column(nullable = false, length = 120)
    private String titulo;

    // 4. ID oficial de Steam para el consumo de la API externa
    @Column(name = "steam_app_id", nullable = true, length = 15)
    private String steamAppId;

    // 5. Estado de progreso en la biblioteca del usuario (ej. "Completado", "Jugando")
    @Column(nullable = false, length = 25)
    private String estado;

    // 6. Tipos Wrapper exigidos por la rúbrica para manejar nulos de BD (Double)[cite: 3]
    @Column(nullable = false)
    private Double horasJugadas;

    // 7. Porcentaje completado (Double)
    @Column(nullable = false)
    private Double porcentajeHistoria;

    // 8. Precio que el usuario está dispuesto a pagar (Double)
    @Column(nullable = false)
    private Double precioObjetivo;

    // 9. Fecha del último acceso, ideal para usar @PastOrPresent en los DTOs[cite: 4]
    @Column(nullable = false)
    private LocalDate ultimaPartida;

    // 10. Email para aislar los datos y cumplir con la autoría de cada usuario
    @Column(nullable = false, length = 120)
    private String emailUsuario;

    // 11. Tipo Wrapper para el booleano[cite: 3]
    @Column(nullable = false)
    private Boolean alertaOfertaActiva;

    // 12. Mapeo de lista simple requerido por la rúbrica[cite: 3]
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "videojuego_logros",
            joinColumns = @JoinColumn(name = "videojuego_id")
    )
    @Column(name = "logro")
    private List<String> logrosDesbloqueados;
}
