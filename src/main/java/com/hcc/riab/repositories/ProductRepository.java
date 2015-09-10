package com.hcc.riab.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcc.riab.model.Product;

@Repository
public interface ProductRepository 
  extends CrudRepository<Product, Long>{

}