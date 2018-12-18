package kr.co.sunnyvale.shop.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import kr.co.sunnyvale.shop.domain.Member;
import kr.co.sunnyvale.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login(){

        return "/members/login";
    }

    @GetMapping("/join")
    public String join(){

        return "/members/join";
    }

    @PostMapping("/join")
    public String joinComplete(
            @RequestParam(name = "email") String email
            , @RequestParam(name = "name") String name
            , @RequestParam(name = "password") String password
    ) {

        memberService.addMember( email, name, password );

        return "/members/login";
    }
}
