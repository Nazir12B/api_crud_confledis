package com.confledis.crud.controller;

import com.confledis.crud.modele.Product;
import com.confledis.crud.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public Product create (@RequestBody Product product) {
        return productService.creat(product);
    }
    @GetMapping("/read")
    public List<Product> read(){
        return productService.read();
    }

    @GetMapping("/read/{id}")
    public Product getProductByID(@PathVariable Integer id){
        return productService.getProductByID(id);
    }
    @PutMapping("/update/{id}")
    public Product update (@RequestBody Product product, @PathVariable Integer id){
        return productService.update(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        return productService.delete(id);
    }
}
