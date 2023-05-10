package com.inventory.Inventory.controller;
import com.inventory.Inventory.model.Products;
import com.inventory.Inventory.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping("/add")
    public String add(@RequestBody Products products){
        return productsService.saveProducts(products);
    }

    @GetMapping("/getAll")
    public List<Products> getAllUsers(){
        return productsService.getAllProducts();
    }

    @GetMapping("/getProductById/{id_product}")
    public Products getProductById(@PathVariable Long id_product){
        return productsService.getProductsById(id_product);
    }

    @PutMapping("/updateProduct/{id_product}")
    public Products updateProduct(@RequestBody Products newProducts, @PathVariable Long id_product){
        return productsService.updateProducts(newProducts, id_product);
    }

    @DeleteMapping("/deleteProduct/{id_product}")
    public String deleteUser(@PathVariable Long id_product){
        return productsService.deleteProducts(id_product);
    }

}
