package com.price.engin.priceengin.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.price.engin.priceengin.Exception.AppException;
import com.price.engin.priceengin.Model.Product;
import com.price.engin.priceengin.Model.ProductDAO;
import com.price.engin.priceengin.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api_product")
public class priceEngine {
    private static final Logger logger = LoggerFactory.getLogger(priceEngine.class);
    @Autowired
    ProductService productService;

    @RequestMapping("/getPrice")
    public Map<String, Object> getPrice(@RequestBody ProductDAO productDAO) throws Exception {

        Map<String, Object> returnObject = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();


        double price = 0.00;
        double calculate = 0.00;
        double singleUnite = 0.00;
        double unitePrice = 0.00;
        long productId = productDAO.getProductId();//
        double qty = productDAO.getQty();

        Product getProductById = productService.getProductById(productId)
                .orElseThrow(() -> new AppException("Product not set."));

        calculate += qty / getProductById.getUnitPerCase();
        int getCartons = (int) calculate;
        singleUnite += (calculate - getCartons) * (int) getProductById.getUnitPerCase();
        int getCartonsPrice = (int) (getCartons * getProductById.getCartoonPrice());
        unitePrice = (getProductById.getCartoonPrice() / getProductById.getUnitPerCase());

        if (qty > (int) getProductById.getUnitPerCase()) {


            if (getCartons >= 3) {
                getCartonsPrice += getCartonsPrice - getCartonsPrice * 10 / 100;
            }

            price += getCartonsPrice + singleUnite * (unitePrice + unitePrice * 130 / 100);

        } else {

            price += singleUnite * (unitePrice + unitePrice * 130 / 100);
            System.out.println("unitePrice ***************************" + unitePrice);
        }

        returnObject.put("price", price);
//        return Response.status(Response.Status.OK).entity(objectMapper.writeValueAsString(returnObject)).build();

        return returnObject;
    }


}




