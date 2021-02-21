package com.price.engin.priceengin.Repository;


import com.price.engin.priceengin.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findAll();
//    public List<String> findAllByproductName();
    public Optional<Product> findById(Long productId);
    public Optional<Product> findByproductName(String productName);
    public Product save(Product product);
    public void deleteById(Long productId);




}










