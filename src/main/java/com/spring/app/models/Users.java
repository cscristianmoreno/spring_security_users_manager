package com.spring.app.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 56)
    private String username;

    @Column(nullable = false, length = 72)
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        joinColumns = {
            @JoinColumn(
                referencedColumnName = "id"
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                referencedColumnName = "id"
            )
        }
    )
    private Set<Authority> authority;
}
