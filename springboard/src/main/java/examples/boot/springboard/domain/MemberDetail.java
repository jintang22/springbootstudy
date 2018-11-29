package examples.boot.springboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member_detail")
@Setter
@Getter
public class MemberDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addr;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
