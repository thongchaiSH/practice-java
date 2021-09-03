package com.data.jpaexa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CUSTOMER_ORDER")
public class OrderEntity {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ORDER_NUMBER")
    private String orderNumber;

    @Column(name = "TOTAL_AMOUNT")
    private String totalAmount;

    @OneToOne
    @JoinColumn(name="CUSTOMER_ID", nullable=false)
    private CustomerEntity customer;
}
