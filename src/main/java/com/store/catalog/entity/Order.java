package com.store.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name="order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = -1274310005104024544L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @Column(name = "name", nullable = false)
    private String number;
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;
    @Column(name = "deliveryAddress", nullable = false)
    private String deliveryAddress;
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;
    @Column(name = "shippingCost", nullable = false)
    private BigDecimal shippingCost;
    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timePurchases", nullable = false)
    private Date timePurchases;


}
