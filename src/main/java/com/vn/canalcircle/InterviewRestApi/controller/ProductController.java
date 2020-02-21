package com.vn.canalcircle.InterviewRestApi.controller;

import com.vn.canalcircle.InterviewRestApi.dto.ResponseEnvelope;
import com.vn.canalcircle.InterviewRestApi.dto.request.ProductUpdateRequest;
import com.vn.canalcircle.InterviewRestApi.model.Product;
import com.vn.canalcircle.InterviewRestApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEnvelope> getAllProducts(){
        Optional<ResponseEnvelope> result = service.getAllProducts();
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEnvelope> getProductById(@PathVariable(value = "id") Long productId){
        Optional<ResponseEnvelope> result = service.getById(productId);
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEnvelope> saveProduct(@Valid @RequestBody Product product){
        Optional<ResponseEnvelope> result = service.save(product);
        return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEnvelope> updateProduct(@PathVariable(value = "id") Long productId,@Valid @RequestBody ProductUpdateRequest request){
        Optional<ResponseEnvelope> result = service.update(productId,request);
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseEnvelope> deleteProduct(@PathVariable(value = "id") Long productId){
        Optional<ResponseEnvelope> result = service.delete(productId);
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }
}
