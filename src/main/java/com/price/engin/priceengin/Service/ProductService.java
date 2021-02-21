package com.price.engin.priceengin.Service;

import com.price.engin.priceengin.Model.Product;
import com.price.engin.priceengin.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;



    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

//    public List<String> findAllByproductName() {
//        for (List<String> productName:Product) {
//
//        }
//        String productName = productRepository.findAll().get().getProductName();
//
//        return productRepository.findAllByproductName();
//    }

    public Optional<Product> getProductById(Long productId) {
        Optional<Product> productGet = productRepository.findById(productId);
        return productGet;
    }


    public Optional<Product> getProductByName(String name) {
        Optional<Product> productGet = productRepository.findByproductName(name);
        return productGet;
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public void deletedById(Long Id) {
        Optional<Product> productGetDb = productRepository.findById(Id);
        if (productGetDb.isPresent()){
            productRepository.deleteById(productGetDb.get().getId());
        }
    }


}
