package kr.co.sunnyvale.shop.service;

import com.sun.corba.se.spi.ior.IORTemplate;
import kr.co.sunnyvale.shop.domain.CartItem;
import kr.co.sunnyvale.shop.domain.Item;
import kr.co.sunnyvale.shop.repository.CartItemRepository;
import kr.co.sunnyvale.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItemInfo(long itemId, String cartIds) {

        List<CartItem> cartItemList = new ArrayList<CartItem>();

        if( 0 != itemId ) {
            CartItem cartItem = new CartItem();
            cartItem.setItem( itemRepository.getOne(itemId) );
            cartItem.setQuantity( 1 );
            cartItem.setPrice( cartItem.getPrice() );
            cartItem.setId(new Long(0));
            cartItemList.add( cartItem );
        }

        if( "" != cartIds ) {
            String[] cartIdArr = cartIds.split(",");
            for (String cartId : cartIdArr) {
                cartItemList.add( cartItemRepository.getOne(Long.parseLong(cartId)) );
            }
        }

        return cartItemList;
    }
}
