package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Board;
import examples.boot.springboard.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardReposiitory boardReposiitory;


    @Test
    public void test1() {

        List<Board> boardList = boardReposiitory.findAll();

        for(Board board : boardList) {
            System.out.println(board.getTitle() + ", " + board.getMember().getName() + ", " + board.getBoardContent().getContent());

        }
    }

    @Test
    public void test2() {

        List<Board> boardList = boardReposiitory.getBoards();

        for(Board board : boardList) {
            System.out.println(board.getTitle() + ", " + board.getMember().getName() + ", " + board.getBoardContent().getContent());
        }
    }

    @Test
    public void test3() {

        Pageable pageable = PageRequest.of(0, 3);
        Page<Board> boardList = boardReposiitory.getBoards(pageable);

        System.out.println(boardList.getTotalPages());
        System.out.println(boardList.getTotalElements());

        for(Board board : boardList) {
            System.out.println(board.getTitle() + ", " + board.getMember().getName() + ", " + board.getBoardContent().getContent());
        }
    }

}
