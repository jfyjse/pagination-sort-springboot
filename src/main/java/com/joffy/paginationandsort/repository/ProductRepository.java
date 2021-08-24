package com.joffy.paginationandsort.repository;

import com.joffy.paginationandsort.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
}
