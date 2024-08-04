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
@Table(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
    @Id
    @Column(name = "review_id")
    private int review_id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "rating")
    private int rating;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created_at")
    private Timestamp created_at;
    @Column(name = "updated_at")
    private Timestamp updated_at;

}
