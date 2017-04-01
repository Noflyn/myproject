package com.dresses.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dresses.model.Product;
import com.dresses.service.ProductService;
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String listPeople(Map<String, Object> map) {

        map.put("product", new Product());
        map.put("productList", productService.listProducts());

        return "product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("Product") Product Product, BindingResult result) {

        productService.add(Product);

        return "redirect:/product/";
    }

    @RequestMapping("/delete/{ProductId}")
    public String deleteProduct(@PathVariable("ProductId") Integer ProductId) {

        productService.removeProduct(ProductId);

        return "redirect:/product/";
    }
}