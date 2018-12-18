package kr.co.sunnyvale.shop.service;

import kr.co.sunnyvale.shop.domain.Item;
import kr.co.sunnyvale.shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Page<Item> pageItemList(int page) {

        Pageable pageable = PageRequest.of(page -1, 10);

        return itemRepository.findAll(pageable);
    }
}
