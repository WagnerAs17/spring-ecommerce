package com.api.product.application.controllers;

import com.api.product.application.dtos.NewProductDto;
import com.api.product.application.dtos.ProductUpdateDto;
import com.api.product.business.useCases.interfaces.ProductUseCase;
import com.api.product.core.domain.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
@Component
public class ProductController extends MainController{

    @Autowired
    private ProductUseCase productUseCase;

    @GetMapping
    public ResponseEntity getAll(){
        return customResponse(this.productUseCase.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody NewProductDto product) throws DomainException {
        this.productUseCase.addProduct(product.name, product.description);

        return customResponse("Product save with success");
    }

    @PutMapping("{id}")
    public ResponseEntity updateProduct(@RequestBody ProductUpdateDto product) throws DomainException {
        this.productUseCase.updateProduct(product.id, product.name, product.description);

        return customResponse("Product updated with success");
    }

}
