package com.example.ecommerce.project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
    @Id
    @Column(name = "category_id")
    private int category_id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

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
