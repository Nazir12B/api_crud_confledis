package com.confledis.crud.service;

import com.confledis.crud.modele.Product;
import com.confledis.crud.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public Product creat(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> read() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Integer id, Product product) {
        return productRepository.findById(id)
                .map(p -> {
                    p.setQuantity(product.getQuantity());
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                    return productRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Produit non trouver"));
    }

    @Override
    public String delete(Integer id) {
        productRepository.deleteById(id);
        return "Produit supprimé";
    }

    @Override
    public Product getProductByID(Integer id) {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Produit non trouver"));
    }
}
