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

    @OneToOne(mappedBy = "board", cascade = CascadeType.PERSIST)
    private BoardContent boardContent;

    private int readCount;
    private LocalDateTime createDate;


}
