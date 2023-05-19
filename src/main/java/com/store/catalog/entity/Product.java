package com.store.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="product")
public class Product implements Serializable{
    @Serial
    private static final long serialVersionUID = 6017625800473342791L;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String Id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "harga", nullable = false)
    private BigDecimal harga;
    @Column(name = "stock", nullable = false)
    private double stock;
    @JoinColumn
    @ManyToOne
    private Category category;

}
