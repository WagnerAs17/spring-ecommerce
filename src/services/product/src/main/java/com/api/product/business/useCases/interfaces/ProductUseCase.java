package com.api.product.business.useCases.interfaces;

import com.api.product.business.models.Product;
import com.api.product.core.domain.DomainException;

import java.util.List;
import java.util.UUID;

public interface ProductUseCase {
    void addProduct(String name , String description) throws DomainException;
    void updateProduct(UUID id, String name, String description) throws DomainException;
    List<Product> getAll();
}
