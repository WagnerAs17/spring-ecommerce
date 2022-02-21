package com.api.product.business.useCases;

import com.api.product.business.models.Product;
import com.api.product.business.useCases.interfaces.ProductUseCase;
import com.api.product.core.domain.DomainException;
import com.api.product.core.validation.Notification;
import com.api.product.infraestructure.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductUseCaseImp implements ProductUseCase {

    private ProductRepository productRepository;
    final Notification notification;

    @Autowired
    public ProductUseCaseImp(ProductRepository productRepository, Notification notification){
        this.productRepository = productRepository;
        this.notification = notification;
    }

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    @Override
    public void addProduct(String name, String description) throws DomainException {
        if(!isValid(name)){
            this.notification.addError("The name of product is requirement");
            return;
        }

        var product = new Product(name, description);

        this.productRepository.save(product);
    }

    @Override
    public void updateProduct(UUID id, String name, String description) throws DomainException {
        var productOptional = this.productRepository.findById(id);

        if(!isValid(name)){
            this.notification.addError("The name of product is requirement");
            return;
        }

        if(!productOptional.isPresent()){
            this.notification.addError(String.format("The product %s is not registered", name));
            return;
        }

        var product = productOptional.get();

        var productUpdate = new Product(product.getId(), name, description, product.getRegistrionDate());

        this.productRepository.save(productUpdate);
    }

    private boolean isValid(String name){
        return !name.isBlank() || !name.isEmpty();
    }
}
