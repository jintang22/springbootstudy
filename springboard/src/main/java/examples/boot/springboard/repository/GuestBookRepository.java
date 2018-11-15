package examples.boot.springboard.repository;

import examples.boot.springboard.domain.GuestBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface GuestBookRepository
    extends JpaRepository<GuestBook, Long> {

    // Spring Data JPA - Query method
    public Page<GuestBook> findAllByOrderByIdDesc(Pageable pageable);
}
