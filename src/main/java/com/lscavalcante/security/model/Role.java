package com.lscavalcante.security.model;

import jakarta.persistence.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<Permission> permissions;

    public Role() {
    }


    /*
        1. .map(permission -> new SimpleGrantedAuthority(permission.getName()))
            Aqui está sendo atribuido todas as permissoes, exemplo se voce criar no banco de dados
            CREATE_ADMIN, READ_ADMIN e assim por diante isso já está sendo atribuido dentro das suas permissoes
        2. authorities.add(new SimpleGrantedAuthority("ROLE_" + this.getName()));
            Ele está pegando o seu atributo da classe Role e atribuindo um ROLE_ na frente pois o
            spring entende as permissoes se ela tiver ROLE_ na frente,
            exemplo: voce cadastrou no banco de dados ADMIN, quando passar por aqui essa permissao vai virar
            ROLE_ADMIN
     */
    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.getName()));
        return authorities;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}

