package kr.co.fastcampus.eatgo.interfaces;

import java.util.ArrayList;
import java.util.List;
import kr.co.fastcampus.eatgo.application.MenuItemService;
import kr.co.fastcampus.eatgo.domain.MenuItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuItemController {

    private final MenuItemService menuItemService;
    @PatchMapping("/restaurants/{restaurantId}/menu-items")
    public String bulkUpdate (@PathVariable Long restaurantId,
                              @RequestBody List<MenuItem> menuItemList) {
        menuItemService.bulkUpdate(restaurantId, menuItemList);
        return "[]";
    }

}
