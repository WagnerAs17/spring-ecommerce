package com.api.product.business.models;

import com.api.product.core.domain.DomainException;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
public class Product implements Serializable {

    private static final Long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = true, length = 1000)
    private String description;

    @Column(nullable = false)
    private LocalDateTime registrionDate;

    protected Product(){}

    public Product(String name, String description) throws DomainException {
        if(!isValid(name))
            throw new DomainException("The name of product is requirement");

        this.name = name;
        this.description = description;
        this.active = true;
        this.registrionDate = LocalDateTime.now();
    }

    public Product(UUID id, String name, String description, LocalDateTime registrionDate){
        this.id = id;
        this.name = name;
        this.description = description;
        this.registrionDate = registrionDate;
        this.active = true;
    }


    public void Disable(){
        this.active = false;
    }

    public boolean isValid(String name){
        return !name.isEmpty() || !name.isBlank();
    }
}
