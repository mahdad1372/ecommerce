package com.example.ecommerce.project.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
public class Payments {
    @Id
    @Column(name = "payment_id")
    private Integer payment_id;
    @Column(name = "order_id")
    private Integer order_id;
    @Column(name = "payment_method")
    private String payment_method;
    @Column(name = "status")
    private String status;
    @Column(name = "payment_date")
    private Timestamp payment_date;

}
