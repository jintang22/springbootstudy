package kr.co.sunnyvale.shop.repository;

import kr.co.sunnyvale.shop.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    public List<CartItem> findAllByMemberId(Long memberId);

}
