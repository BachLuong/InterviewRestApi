package com.vn.canalcircle.InterviewRestApi.repository;

import com.vn.canalcircle.InterviewRestApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
