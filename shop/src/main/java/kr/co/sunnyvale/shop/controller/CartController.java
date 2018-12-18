package kr.co.sunnyvale.shop.controller;

import kr.co.sunnyvale.shop.security.CustomUserDetails;
import kr.co.sunnyvale.shop.service.CartService;
import kr.co.sunnyvale.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String cart(ModelMap map){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object obj = authentication.getPrincipal();

        if( obj instanceof CustomUserDetails) {

            CustomUserDetails loginUser = (CustomUserDetails)authentication.getPrincipal();

            map.addAttribute("cartList", cartService.listCart(loginUser.getId()));
        }
        else {
            map.addAttribute("cartList", null);
        }

        return "/cart/cart";
    }
}
