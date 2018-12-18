package kr.co.sunnyvale.shop.service;

import kr.co.sunnyvale.shop.domain.CartItem;
import kr.co.sunnyvale.shop.domain.Item;
import kr.co.sunnyvale.shop.repository.CartItemRepository;
import kr.co.sunnyvale.shop.repository.ItemRepository;
import kr.co.sunnyvale.shop.repository.MemberRepository;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ItemRepository itemRepository;


    public CartItem addCart(Long memberId, Long itemId) {

        Item item = itemRepository.getOne(itemId);

        Optional<CartItem> cartItemOptional = cartItemRepository.findByMemberIdAndItemId(memberId, itemId);

        if(false == cartItemOptional.isPresent() ) {

            CartItem cartItem = new CartItem();
            cartItem.setMember(memberRepository.getOne(memberId));
            cartItem.setPrice(item.getPrice());
            cartItem.setQuantity(1);
            cartItem.setItem(item);
            return cartItemRepository.save(cartItem);
        }
        else {
            cartItemOptional.get().setQuantity( cartItemOptional.get().getQuantity() + 1 );
            return cartItemRepository.save(cartItemOptional.get());
        }
    }

    public void removeCart(Long cartId) {

        cartItemRepository.deleteById(cartId);
    }

    public List<CartItem> listCart(Long memberId) {

        return cartItemRepository.findAllByMemberId(memberId);
    }
}
