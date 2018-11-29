package examples.boot.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "board_content")
@Setter
@Getter
public class BoardContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Lob                            // 대용량 컬럼은 이렇게 annotation 으로 지정
    @Basic(fetch = FetchType.LAZY)  // 이 컬럼은 바로 조회하지 않고 사용될때 다시조회한다.
    private String content;

}
