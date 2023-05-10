package com.inventory.Inventory.service;
import com.inventory.Inventory.model.Products;
import java.util.List;
public interface ProductsService {
    String saveProducts(Products products);
    public List<Products> getAllProducts();
    Products getProductsById(Long id_product);
    Products updateProducts(Products newProducts, Long id_product);
    String deleteProducts(Long id_product);
}
