package kr.co.sunnyvale.shop.controller;

import kr.co.sunnyvale.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("order")
    public String order(
            @RequestParam(name = "itemId", required = false, defaultValue = "0") Long itemId
            , @RequestParam(name = "cartIds", required = false, defaultValue = "") String cartIds
            , ModelMap map
    ) {
        if( "".equals(cartIds) && 0 == itemId ) {
            return "/error";
        }

        map.addAttribute("cartItemsList", orderService.getCartItemInfo(itemId, cartIds));

        return "/order/order";
    }
}