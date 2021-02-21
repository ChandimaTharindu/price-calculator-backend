package com.price.engin.priceengin.Controller;


import com.price.engin.priceengin.Model.Product;
import com.price.engin.priceengin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api_product")
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping("/getAllPraduct")
    public List<Product> getAllPatient() throws Exception{
    return productService.getAllProduct();
    }

//    @RequestMapping("/getAllPraductName")
//    public List<String> getAllPraductName() throws Exception{
//
//        Product p = new Product();
//        for (List<String> f:p.getProductName()) {
//
//        }
//        return productService.getAllProduct().get().getProductName();
//    }

    @RequestMapping("/getProductById/{Id}")
    public Product getPatientById(@PathVariable Long Id) throws Exception{
    Optional<Product> productDb = productService.getProductById(Id);
    if (!productDb.isPresent()) {
        throw new Exception("Could not find Product with id- " + Id);
    }else {
        return productDb.get();
    }

    }

    @RequestMapping("/getCartoonPriceProductById/{Id}")
    public double getCartoonPriceProductById(@PathVariable Long Id) throws Exception{
        Optional<Product> productDb = productService.getProductById(Id);
        if (!productDb.isPresent()) {
            throw new Exception("Could not find Product with id- " + Id);
        }else {
            return productDb.get().getCartoonPrice();
        }

    }

    @RequestMapping("/getAllProductByName/{name}")
    public Product getPatientByName(@PathVariable String name) throws Exception{
        Optional<Product> productDb = productService.getProductByName(name);
        if (!productDb.isPresent()) {
            throw new Exception("Could not find productDb with name- " + name);
        }else {
            return productDb.get();
        }
    }


//    @RequestMapping(method = RequestMethod.POST, value = "/addPatient")
//    public Patient creatPatient(@Valid @RequestBody PatientAddRequest patientAddRequest){
//
//        Patient patient = new Patient(patientAddRequest.getPatientId(),patientAddRequest.getName(),patientAddRequest.getPositiveDate(),
//                patientAddRequest.getAddres(),patientAddRequest.getAge(),patientAddRequest.getTelephone(),patientAddRequest.getRemark());
//
//        Distric distric = districRepository.findById(patientAddRequest.getDistricId())
//                .orElseThrow(() -> new AppException("Patient distric not set."));
//
//        GramaSewaDevision gramaSewaDevision = gramaSewaDevisionRepository.findById(patientAddRequest.getGramaSewaDevisionId())
//                .orElseThrow(() -> new AppException("Patient Grama Sewa Devision not set."));
//
//
//        patient.setDistric(distric);
//        patient.setGramaSewaDevision(gramaSewaDevision);
//
//        return patientService.createPatient(patient);
//
//    }
//
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/deletePatient/{Id}")
//    public void deletePatient(@PathVariable Long Id) throws Exception {
//
//        Optional <Patient> patientDb = patientService.getPatientById(Id);
//        if (patientDb.isPresent()){
//
//            this.patientService.deletedById(Id);
//
//        }else {
//
//            throw new Exception("Could not find customer with id- " + Id);
//        }
//
//
//    }


}
