package com.mvcspring.repository;

import com.mvcspring.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByNameContains(String keyword, Pageable pageable);

    /*@Query("select  p from Product p where p.name like :x")
    Page<Product> search(@Param("x") String keyword, Pageable pageable);*/

}
