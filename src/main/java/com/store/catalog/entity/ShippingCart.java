package com.store.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "shippingCart")
public class ShippingCart implements Serializable {
    @Serial
    private static final long serialVersionUID = 5156255763573572412L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @JoinColumn
    @ManyToOne
    private Product product;
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;
    @Column(name = "kuantitas", nullable = false)
    private Double kuantitas;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timemade", nullable = false)
    private Date timeMade;
}
