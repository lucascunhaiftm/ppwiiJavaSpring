package br.edu.iftm.meuAppSpringJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.iftm.meuAppSpringJava.model.Product;
import br.edu.iftm.meuAppSpringJava.service.ProductService;
import jakarta.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String index(Model model) {
        model.addAttribute("productsList", productService.getAllProducts());
        return "product/index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute @Valid Product product, BindingResult result, Model model) {

        System.out.println(product);
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            return "product/create";
        }

        productService.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.productService.deleteProductById(id);
        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/edit";
    }

}