package kr.co.sunnyvale.shop.controller.api;

import kr.co.sunnyvale.shop.security.CustomUserDetails;
import kr.co.sunnyvale.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartApiController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addCart(
            @RequestParam(name = "itemId") Long itemid
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object obj = authentication.getPrincipal();

        if( obj instanceof CustomUserDetails) {

            CustomUserDetails loginUser = (CustomUserDetails)authentication.getPrincipal();

            cartService.addCart(loginUser.getId(), itemid);
            return "장바구니에 추가하였습니다.";
        }

        return "로그인이 필요합니다.";
    }

    @PostMapping("/remove")
    public String removeCart(@RequestParam(name = "cartId") Long cartId){

        cartService.removeCart(cartId);

        return "장바구니 삭제가 완료되었습니다.";
    }
}
