package com.store.catalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="orderlog")
public class OrderLog implements Serializable {
    @Serial
    private static final long serialVersionUID = -6664277353311392597L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @JoinColumn
    @ManyToOne
    private Order order;
    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;
    @Column(name = "logType", nullable = false)
    private Integer logType;
    @Column(name = "logMessage", nullable = false)
    private String logMessage;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time", nullable = false)
    private Date time;


}
