package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BoardReposiitory extends JpaRepository<Board, Long> {

    @Query("select b from Board b inner join fetch b.member inner join fetch b.boardContent")
    public List<Board> getBoards();


//    @Query(value = "select b from Board b inner join fetch b.member inner join fetch b.boardContent order by b.id desc"
//    , countQuery = "select count(1) from Board b")
//    public Page<Board> getBoards(Pageable pageable);

    @Query(value = "select b from Board b order by b.id desc"
    , countQuery = "select count(1) from Board b")
    public Page<Board> getBoards(Pageable pageable);
}
