package examples.boot.springboard.service;

import examples.boot.springboard.domain.GuestBook;
import org.springframework.data.domain.Page;

/**
 * 비지니스 메소드를 가지는 서비스 interface 목록
 */
public interface GuestBookService {

    public GuestBook addGuestBook(GuestBook guestBook);

    public Page<GuestBook> getGuestBook(int page);
}
