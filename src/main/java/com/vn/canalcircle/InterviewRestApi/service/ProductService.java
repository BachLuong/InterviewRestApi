package com.vn.canalcircle.InterviewRestApi.service;

import com.vn.canalcircle.InterviewRestApi.dto.ErrorCode;
import com.vn.canalcircle.InterviewRestApi.dto.ResponseEnvelope;
import com.vn.canalcircle.InterviewRestApi.dto.ResponseEnvelopeFactory;
import com.vn.canalcircle.InterviewRestApi.dto.request.ProductUpdateRequest;
import com.vn.canalcircle.InterviewRestApi.exception.ProductNotfoundException;
import com.vn.canalcircle.InterviewRestApi.model.Product;
import com.vn.canalcircle.InterviewRestApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Optional<ResponseEnvelope> getAllProducts(){
        ResponseEnvelope result = ResponseEnvelopeFactory.create();
        List<Product> lstProducts = repository.findAll();
        result.setResult(lstProducts);
        result.setCode(ErrorCode.OK);
        return Optional.of(result);
    }

    public Optional<ResponseEnvelope> getById(Long id) throws ProductNotfoundException {
        ResponseEnvelope result = ResponseEnvelopeFactory.create();
        Product entity = repository.findById(id).orElseThrow(() -> new ProductNotfoundException(String.format("Product id %d is not found!",id)));
        result.setResult(entity);
        result.setCode(ErrorCode.OK);
        return Optional.of(result);
    }

    public Optional<ResponseEnvelope> save(Product product){
        ResponseEnvelope result = ResponseEnvelopeFactory.create();
        Product entity = repository.save(product);
        result.setResult(entity);
        result.setCode(ErrorCode.OK);
        return Optional.of(result);
    }

    public Optional<ResponseEnvelope> delete(Long id) throws ProductNotfoundException {
        ResponseEnvelope result = ResponseEnvelopeFactory.create();
        Product entity = repository.findById(id).orElseThrow(() -> new ProductNotfoundException(String.format("Product id %d is not found!",id)));
        repository.delete(entity);
        result.setCode(ErrorCode.OK);
        return Optional.of(result);
    }

    public Optional<ResponseEnvelope> update(Long id, ProductUpdateRequest updateRequest) throws ProductNotfoundException {
        ResponseEnvelope result = ResponseEnvelopeFactory.create();
        Product entity = repository.findById(id).orElseThrow(() -> new ProductNotfoundException(String.format("Product id %d is not found!",id)));
        entity.setProductDescription(updateRequest.getProductDescription());
        entity.setProductName(updateRequest.getProductName());
        result.setResult(repository.save(entity));
        result.setCode(ErrorCode.OK);
        return Optional.of(result);
    }
}
