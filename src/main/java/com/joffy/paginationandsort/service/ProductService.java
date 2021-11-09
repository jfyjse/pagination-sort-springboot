package com.joffy.paginationandsort.service;

import com.joffy.paginationandsort.entity.ProductEntity;
import com.joffy.paginationandsort.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    // adding dummy products
    
   @PostConstruct
   public void initDb(){
       List<ProductEntity> products = IntStream.rangeClosed(1,400)
               .mapToObj(i-> new ProductEntity("product n"+i,new Random().nextInt(100),
                       new Random().nextInt(5000))).collect(Collectors.toList());
       productRepository.saveAll(products);
   }

    public List<ProductEntity> findAllProducts(){
        return productRepository.findAll();
    }

    public List<ProductEntity> findProductSort(String input){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC,input));
    }
    public Page<ProductEntity> findProductPagination(int offset, int pageSize){
        return productRepository.findAll(PageRequest.of(offset,pageSize));
    }

    public Page<ProductEntity> findProductPaginationSort(int offset, int pageSize, String input){
        return productRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(Sort.Direction.ASC, input)));
    }

}
