package tang.study.tangshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_goods")
@Setter
@Getter
public class PurchaseGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    private int count;

    private int order_amount;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private LocalDateTime regdate;

}
