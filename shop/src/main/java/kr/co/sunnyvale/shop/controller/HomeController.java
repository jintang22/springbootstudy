package kr.co.sunnyvale.shop.controller;

import kr.co.sunnyvale.shop.domain.Item;
import kr.co.sunnyvale.shop.security.AuthUser;
import kr.co.sunnyvale.shop.security.CustomUserDetails;
import kr.co.sunnyvale.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String login(ModelMap map){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object obj = authentication.getPrincipal();

        if( obj instanceof CustomUserDetails ) {

            map.addAttribute("loginStatus", "Login");

            CustomUserDetails loginUser = (CustomUserDetails)authentication.getPrincipal();

            map.addAttribute("name", loginUser.getName());
        }
        else {
            map.addAttribute("loginStatus", "Logout");
        }

        map.addAttribute("itemPage", itemService.pageItemList(1));

        return "/index";
    }
}
