package kr.co.sunnyvale.shop.repository;

import kr.co.sunnyvale.shop.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    public List<CartItem> findAllByMemberId(Long memberId);

    public Optional<CartItem> findByMemberIdAndItemId(Long memberId, Long itemId);

}
