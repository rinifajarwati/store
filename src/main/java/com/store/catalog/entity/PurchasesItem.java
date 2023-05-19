package com.store.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "purchasesItem")
public class PurchasesItem implements Serializable {
    @Serial
    private static final long serialVersionUID = -1156682874228733163L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @JoinColumn
    @ManyToOne
    private Order order;
    @JoinColumn
    @ManyToOne
    private Product product;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "kuantitas", nullable = false)
    private Double kuantitas;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;
}
