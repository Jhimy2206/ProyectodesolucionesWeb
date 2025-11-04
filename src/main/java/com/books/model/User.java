package com.books.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idUser;

    @Column(nullable = false, length = 60, unique = true)
    private String username;           // ej: juan.perez

    @Column(nullable = false, length = 120)
    private String password;           // BCrypt hash (60-120 chars)

    @Column(nullable = false)
    private boolean enabled = true;

    @Column(length = 70)
    private String firstName;

    @Column(length = 70)
    private String lastName;

    @Column(length = 100)
    private String email;

    // RELACIÓN CON ROLES (ADMIN, BIBLIOTECARIO, SUPERVISOR)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole")
    )
    private List<Role> roles;

}
