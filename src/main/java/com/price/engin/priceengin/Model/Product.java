package com.price.engin.priceengin.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unite_per_case")
    private int unitPerCase;

    @Column(name = "cartoon_price")
    private double cartoonPrice;

    public Product(){

    }

    public Product(Long id, String productName, int unitPerCase, double cartoonPrice) {
        this.id = id;
        this.productName = productName;
        this.unitPerCase = unitPerCase;
        this.cartoonPrice = cartoonPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitPerCase() {
        return unitPerCase;
    }

    public void setUnitPerCase(int unitPerCase) {
        this.unitPerCase = unitPerCase;
    }

    public double getCartoonPrice() {
        return cartoonPrice;
    }

    public void setCartoonPrice(double cartoonPrice) {
        this.cartoonPrice = cartoonPrice;
    }
}
