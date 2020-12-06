package kr.co.fastcampus.eatgo.interfaces;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import kr.co.fastcampus.eatgo.application.MenuItemService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuItemController.class)
class MenuItemControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MenuItemService menuItemService;

    @Test
    public void 벌크업데이트() throws Exception {
        mvc.perform(patch("/restaurants/1/menu-items")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content("[]"))
           .andExpect(status().isOk());

        // menuItemService 의 bulkUpdate 메소드가 실행되길 원함
        verify(menuItemService).bulkUpdate(eq(1L), any());
    }
}
