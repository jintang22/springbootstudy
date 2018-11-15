package examples.boot.springboard.controller;

import examples.boot.springboard.domain.GuestBook;
import examples.boot.springboard.repository.GuestBookRepository;
import examples.boot.springboard.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/*
Spring boot 에서 Web이라는 것을 사용하면, Tomcat이라는 WAS가 내장되서 실행된다.
web = spring-boot-starter-web

 */
@Controller
public class GuestBookController {

    @Autowired
    GuestBookService guestBookService;

    @GetMapping("/")
    public String list(
            @RequestParam(name = "page", defaultValue = "0") int page
            , ModelMap modelMap
    ) {
        Page<GuestBook> guestBooks = guestBookService.getGuestBook(page);

        System.out.println(guestBooks);
        for (GuestBook guestBook: guestBooks
        ) {
            System.out.println(guestBook.getId() + guestBook.getName() + guestBook.getContent());
        }

        modelMap.addAttribute("guestBookPage", guestBooks.getContent());

        return "index";
    }

    @PostMapping("/write")
    public String write(
            @RequestParam(name = "name") String name
            , @RequestParam(name ="content") String content
    ){
        GuestBook guestBook = new GuestBook();
        guestBook.setName(name);
        guestBook.setContent(content);
        guestBook.setRegdate(new Date());
        guestBook = guestBookService.addGuestBook(guestBook);
        return "redirect:/";
    }

}
