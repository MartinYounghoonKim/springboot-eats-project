package kr.co.fastcampus.eatgo.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MenuItemServiceTest {
    private MenuItemService menuItemService;

    @Mock
    private MenuItemRepository menuItemRepository;

    @BeforeEach
    public void setUp () {
        MockitoAnnotations.initMocks(this);

        menuItemService = new MenuItemService(menuItemRepository);
    }

    @Test
    public void 벌크업데이트 () {
        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(MenuItem.builder()
                              .name("Kimchi")
                              .build());
        menuItems.add(MenuItem.builder()
                              .name("Gukbab")
                              .build());
        menuItemService.bulkUpdate(1L, menuItems);

        // 두번 실행되는 것을 테스트
        verify(menuItemRepository, times(2)).save(any());
    }

}
