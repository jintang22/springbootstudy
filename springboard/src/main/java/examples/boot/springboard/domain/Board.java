package examples.boot.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="board")
@Setter
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany
    private Set<UploadFile> uploadFileS;


    private String title;           // String 은 default 로 255자로 매핑됨

    @Lob                            // 대용량 컬럼은 이렇게 annotation 으로 지정
    @Basic(fetch = FetchType.LAZY)  // 이 컬럼은 바로 조회하지 않고 사용될때 다시조회한다.
    private String content;
    private int readCount;
    private LocalDateTime createDate;


}
