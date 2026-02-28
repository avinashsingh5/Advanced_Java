package com.example.productApp.Exceptions;

import com.example.productApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ProductService service;

    @GetMapping("/count")
    @ResponseBody
    public String getProductCount() {
        return "Total Products: " + service.getAllProducts().size();
    }

    @ExceptionHandler(Exception.class)
    public String handleGlobalException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Something Went Wrong");
        return "error-Page";
    }
}