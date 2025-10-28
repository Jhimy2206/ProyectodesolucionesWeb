package com.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//@Table(name="tbl_patient", schema =  "Sistematicos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int idUsuario;


    @Column(nullable = false, length = 70)
    private String nombre;



    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String tipoUsuario; // "ADMIN" o "LECTOR"

}
