package com.store.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name = "pengguna" )
public class Pengguna implements Serializable {
    @Serial
    private static final long serialVersionUID = -611996565265386666L;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "roles", nullable = false)
    private String roles;

}
