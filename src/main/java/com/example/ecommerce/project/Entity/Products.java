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
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;
    @Column(name = "stock_quantity")
    private Integer stock_quantity;
    @Column(name = "category_id")
    private Integer category_id;
    @Column(name = "created_at")
    private Timestamp created_at;
    @Column(name = "updated_at")
    private Timestamp updated_at;
    public int getCategory_id() {
        return category_id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
