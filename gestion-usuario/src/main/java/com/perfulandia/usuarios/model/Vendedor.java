package com.perfulandia.usuarios.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // entidad JPA, mapea una tabla
@Table(name="VENDEDOR") // nombre tabla que represneta la entidad

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor {
    
    @Id // declara PK entidad 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor") // mapea este atributo
    private Integer idVendedor;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    private String nombre;
    private String apellido;
    private String rut;
    private String sucursal;
    private String areaVenta;

}
