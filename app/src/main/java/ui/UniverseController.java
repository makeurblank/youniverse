package ui;

import application.ItemService;
import application.SocialLoginService;
import domain.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class UniverseController {

    private final SocialLoginService socialLoginService;
    private final ItemService itemService;

    public UniverseController(SocialLoginService socialLoginService,
                              ItemService itemService) {
        this.socialLoginService = socialLoginService;
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> list() {
        return itemService.getItems();
    }
}
