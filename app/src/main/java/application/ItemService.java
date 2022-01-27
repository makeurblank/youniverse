package application;

import domain.Item;
import infra.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated() and hasAuthority('USER')")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

}
