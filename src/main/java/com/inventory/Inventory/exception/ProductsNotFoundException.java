package com.inventory.Inventory.exception;

public class ProductsNotFoundException extends RuntimeException{

    public ProductsNotFoundException(Long id_product){
        super("Could not found the Product with id " + id_product);
    }
}
