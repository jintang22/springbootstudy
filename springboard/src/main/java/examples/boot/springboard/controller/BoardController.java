package examples.boot.springboard.controller;

import examples.boot.springboard.domain.Board;
import examples.boot.springboard.security.AuthUser;
import examples.boot.springboard.security.LoginUser;
import examples.boot.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.AuthProvider;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/writeform")
    public String writeform(@AuthUser LoginUser loginUser, ModelMap map) {
        //System.out.println(principal.getName());

        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        System.out.println("-----");
        System.out.println( loginUser.getName() );
        System.out.println("-----");

        map.addAttribute("name", loginUser.getName());

        return "boards/writeform";
    }

    @PostMapping
    public String write(@AuthUser LoginUser loginUser
                        , @RequestParam(name = "title") String title
                        , @RequestParam(name = "content") String content
    ) {
        boardService.addBoard(loginUser.getUserId(), title, content);
        return "redirect:/boards";
    }

    @GetMapping
    public String boards(@RequestParam(name = "page", required = false, defaultValue = "1") int page
                         , @AuthUser LoginUser loginUser, ModelMap map){

        if(page < 1 )
            page = 1;

        map.addAttribute("boardPage", boardService.getBoards(page));

        return "boards/list";   // view name
    }


}
