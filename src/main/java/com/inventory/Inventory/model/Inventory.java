package com.inventory.Inventory.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity @Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventory")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_movement")
    private Movements movements;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Products products;
    /*
    @ManyToOne
    @JoinColumn(name = "id_invoice")
    private InvoiceHeader invoice;
    */
    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "movementDate")
    private Date movementDate;

    @Column(name = "movementHour")
    private Time movementHour;
}
