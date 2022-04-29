package com.example.pe_bune.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "orders")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Date orderDate;

    public Order(Date time) {
        this.orderDate = time;
    }
}
