package kr.co.sunnyvale.shop.service;

import kr.co.sunnyvale.shop.domain.CartItem;
import kr.co.sunnyvale.shop.repository.CartItemRepository;
import kr.co.sunnyvale.shop.repository.ItemRepository;
import kr.co.sunnyvale.shop.repository.MemberRepository;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ItemRepository itemRepository;


    public CartItem addCart(Long memberId, Long itemId) {

        CartItem cartItem = new CartItem();
        cartItem.setMember( memberRepository.getOne(memberId) );
        cartItem.setPrice( 100 );
        cartItem.setQuantity( 1 );
        cartItem.setProduct( itemRepository.getOne(itemId) );

        return cartItemRepository.save( cartItem );
    }

    public List<CartItem> listCart(Long memberId) {

        return cartItemRepository.findAllByMemberId(memberId);
    }
}
