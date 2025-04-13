package com.mvcspring;

import com.mvcspring.entity.Product;
import com.mvcspring.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MvcSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product product = Product.builder()
                    .name("Samsung Galaxy S21")
                    .price(999.99)
                    .quantity(5)
                    .build();
            productRepository.save(product);
            productRepository.save(new Product(null, "Iphone 14", 1200.0, 10));
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }

}
