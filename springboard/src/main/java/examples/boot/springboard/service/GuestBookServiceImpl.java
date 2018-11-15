package examples.boot.springboard.service;


import examples.boot.springboard.domain.GuestBook;
import examples.boot.springboard.repository.GuestBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    private GuestBookRepository guestBookRepository;

    // 아래 생성자 주입 대신에 @authwired 로 사용
    // 생성자 주입
    /*
    public GuestBookServiceImpl(GuestBookRepository guestBookRepository) {
        this.guestBookRepository = guestBookRepository;
    }
    */

    @Override
    @Transactional
    public GuestBook addGuestBook(GuestBook guestBook) {
        return guestBookRepository.save(guestBook);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GuestBook> getGuestBook(int page) {

        // page가 0이면 0번째부터 5건
        // page가 1이면 5번째부터 5건을 보여준다.
        Pageable pageable = PageRequest.of(page, 5);
        //return guestBookRepository.findAll(pageable);
        return guestBookRepository.findAllByOrderByIdDesc(pageable);
    }
}
