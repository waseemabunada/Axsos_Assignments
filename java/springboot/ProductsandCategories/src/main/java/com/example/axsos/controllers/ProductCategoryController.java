package com.example.axsos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.axsos.models.Category;
import com.example.axsos.models.Product;
import com.example.axsos.models.User;
import com.example.axsos.services.CategoryService;
import com.example.axsos.services.ProductService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProductCategoryController {	

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;



	@GetMapping("/home")
	public String index(Model model,HttpSession session) {

		User loggedUser = (User) session.getAttribute("loggedUser");

	    if (loggedUser != null) {

	        model.addAttribute("user", loggedUser); 
			model.addAttribute("products", productService.allProducts());
		    model.addAttribute("categories", categoryService.allCategorys());
	        return "Home";

	    } else {
	        return "redirect:/";
	    }
		
	}

	@GetMapping("/products/new")
    public String productsnew(@ModelAttribute Product product,HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");
	    if (loggedUser != null) {
	        return "newproduct";
	    } else {
	        return "redirect:/";
	    }

	}

	@GetMapping("/categories/new")
    public String categoriesnew(@ModelAttribute Category category,HttpSession session) {

		User loggedUser = (User) session.getAttribute("loggedUser");
	    if (loggedUser != null) {
	        return "newcategory";
	    } else {
	        return "redirect:/";
	    }

	}
	
	@GetMapping("/products/{id}")
    public String productsshow(@PathVariable Long id,Model model,HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");
	    if (loggedUser != null) {

		Product product = productService.findProduct(id);
		model.addAttribute("product"  , product);
		model.addAttribute("unassigned", categoryService.getCategoriesByNotContain(product));
	    return "showproduct";

	    } else {
	        return "redirect:/";
	    }
	
	}
	
	@GetMapping("/categories/{id}")
    public String categoriesshow(@PathVariable Long id,Model model,HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");
	    if (loggedUser != null) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category"  , category);
		model.addAttribute("unassigned", productService.getProductsByNotContain(category));
		return "showcategory";
		 } else {
	        return "redirect:/";
	    }
	}
	
	
	@PostMapping("/categories")
	public String create(@Valid @ModelAttribute Category category, BindingResult result, Model model,HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");
	    if (loggedUser != null) {
		if (result.hasErrors()) {
			return "newcategory";
		}
		categoryService.createCategory(category);
		return "redirect:/categories/"+category.getId();
		 } else {
	        return "redirect:/";
	    }
	} 
	
	@PostMapping("/products")
	public String create(@Valid @ModelAttribute Product product, BindingResult result, Model model,HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");
	    if (loggedUser != null) {
		if (result.hasErrors()) {
			return "newproduct";
		}
		productService.createProduct(product);
		return "redirect:/products/" + product.getId();
			 } else {
	        return "redirect:/";
	    }
	} 
	
	@PostMapping("/categories/{id}/addProduct")
	public String addProduct(@RequestParam Long productId,@PathVariable("id") Long categoryId, HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");
	    if (loggedUser != null) {
		Category category = categoryService.findCategory(categoryId);
		Product product = productService.findProduct(productId);
		
		categoryService.addProduct(category, product);
		
		return "redirect:/categories/" + category.getId();
			 } else {
	        return "redirect:/";
	    }
	}
	
	@PostMapping("/products/{id}/addCategory")
	public String addCategory(@PathVariable("id") Long productId,@RequestParam Long categoryId, HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");
	    if (loggedUser != null) {
		Category category = categoryService.findCategory(categoryId);
		Product product = productService.findProduct(productId);
		
		productService.addCategory(category, product);
		
		return "redirect:/products/" + product.getId();
			 } else {
	        return "redirect:/";
	    }
	}
	
	
	
}