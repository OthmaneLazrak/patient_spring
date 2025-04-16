package com.mvcspring.web;

import com.mvcspring.entity.Product;
import com.mvcspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/index")
    public String  index(Model model,@RequestParam(name="page",defaultValue = "0") int page,
                         @RequestParam(name = "size",defaultValue = "3") int size,
                         @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Product> pageproducts = productRepository.findByNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListProducts", pageproducts.getContent());
        model.addAttribute("pages", new int[pageproducts.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "products";
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam(name = "id") Long id,String keyword, int page){
        productRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
}
