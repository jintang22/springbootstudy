package examples.boot.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
/*
    // 영속성 객체를 먼저 메모리에 생성
    GuestBook guestBook = new Guestbook();

    영속성관리자.영속성부여(guestbook);

 */
@Entity // 영속성 객체.
@Table(name="guestbook")
@Setter
@Getter
public class GuestBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String content;

    Date regdate;
}
