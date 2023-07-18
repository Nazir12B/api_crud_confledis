package com.confledis.crud.repository;

import com.confledis.crud.modele.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
