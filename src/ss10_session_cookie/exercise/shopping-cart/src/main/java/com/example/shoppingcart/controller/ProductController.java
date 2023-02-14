package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public String getPageHomeShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/shop";
    }

    @GetMapping("/add/{id}")
    public String saveToCart(@PathVariable("id") Long id, @ModelAttribute Cart cart,
                             @RequestParam(value = "action", required = false, defaultValue = "") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/view/{id}")
    public String getPageViewProduct(@PathVariable("id") Long id, Model model){
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product",product);
        return "/view";
    }

    @GetMapping("/remove/{id}")
    public String removeToCart(@PathVariable("id") Long id, @ModelAttribute Cart cart,
                               @RequestParam(value = "action", required = false, defaultValue = "") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }

        Map.Entry<Product, Integer> itemEntry = cart.selectItemInCard(product.get());

        if (itemEntry.getValue() == 1 || action.equals("delete")) {
            cart.removeProduct(itemEntry.getKey());
            return "redirect:/shopping-cart";
        }
        cart.decreaseQuantity(product.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/pay")
    public String solveMoney(RedirectAttributes redirectAttributes, @ModelAttribute Cart cart) {
        if (cart.removeAllProduct()) {
            redirectAttributes.addFlashAttribute("mess", "Thanh toán thành công");
        } else {
            redirectAttributes.addFlashAttribute("mess", "Giỏ hàng rỗng nên không thể thanh toán");
        }
        return "redirect:/shopping-cart";
    }
}
