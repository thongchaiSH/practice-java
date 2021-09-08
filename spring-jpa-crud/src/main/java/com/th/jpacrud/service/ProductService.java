package com.th.jpacrud.service;

import com.th.jpacrud.dao.ProductRepository;
import com.th.jpacrud.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> findAll() {
        List<Product> result=new ArrayList<>();
        productRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product stock) {
        return productRepository.save(stock);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByPage(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Product> pagedResult=productRepository.findAll(paging);
        List<Product> result=new ArrayList<>();
        if(pagedResult.hasContent()){
            result= pagedResult.getContent();
        }
        return result;
    }

    public Page<Product>  findPage(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Product> pagedResult=productRepository.findAll(paging);
        return pagedResult;
    }
}
