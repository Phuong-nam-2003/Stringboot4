package com.example.testspring.controller;

import com.example.testspring.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
@RequestMapping("/product")
public class ProductController {
    private List<Product> products;
    @PostConstruct
    private void loadData(){
        Product pr1 = new Product(1,"iphone11","blue",500,15);
        Product pr2 = new Product(2,"iphone12","red",1000,25);
        Product pr3 = new Product(3,"iphone13","gold",1500,35);

        products = new ArrayList<>();

        products.add(pr1);
        products.add(pr2);
        products.add(pr3);
    }
    @GetMapping("/list")
    public String listProduct(Model theModel) {
        theModel.addAttribute("products",products);
        return "list_products";
    }
}
