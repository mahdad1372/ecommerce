package com.example.ecommerce.project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Addresses {
    @Id
    @Column(name = "address_id")
    private int address_id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "postal_code")
    private int postal_code;
    @Column(name = "country")
    private String country;
}
