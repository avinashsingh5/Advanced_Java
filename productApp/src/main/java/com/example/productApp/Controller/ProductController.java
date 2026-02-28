package com.example.productApp.Controller;
import com.example.productApp.Model.Product;
import com.example.productApp.Service.ProductService;
import jakarta.validation.Valid;
import org.apache.tomcat.websocket.server.WsWriteTimeout;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/products")
@SessionAttributes("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @ModelAttribute("product")
    public Product getProduct(){
        return new Product();
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/list")
    public  String viewProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    @GetMapping("/add")
    public String showAddForm(){
        return "product-form";
    }

    @PostMapping("/save")
    public String savaProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, SessionStatus sessionStatus){
        if(result.hasErrors()){
            return "product-form";
        }
        productService.saveProduct(product);
        sessionStatus.setComplete();
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model){
        Product product = productService.getProductById(id).orElseThrow(()->new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        if(productService.getProductById(id).isEmpty()){
            throw  new RuntimeException("Cannot Delete. Product Not Found");
        }
        productService.deleteProduct(id);
        return "redirect:/products/list";
    }




}