package com.confledis.crud.service;

import com.confledis.crud.modele.Product;

import java.util.List;

public interface ProductService {
    Product creat (Product product);
    List<Product> read();
    Product update(Integer id, Product product);

    String delete(Integer id);
    Product getProductByID(Integer id);


}
