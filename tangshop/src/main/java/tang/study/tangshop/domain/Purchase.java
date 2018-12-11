package tang.study.tangshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase")
@Setter
@Getter
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String status;

    private long total_order_amount;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime regdate;

}
