package com.pixel.school;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.pixel.basic.dto.MenuDto;
import com.pixel.basic.model.Menu;
import com.pixel.basic.service.MenuServiceImpl;
import com.pixel.basic.tools.AuthTools;


/**
 * 
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("pixel")
public class MenuTest {

    @Autowired
    private AuthTools authTools;

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    @Test
    public void initMenus() {
        
        authTools.buildSystemMenu("com/pixel/basic/controller/*Controller.class");
    }

    @Test
    public void testQueryMenus() {
        List<MenuDto> list = menuServiceImpl.queryMenuDtoNew(1);
        System.out.println(list.size());
        for(MenuDto md : list) {
            System.out.println("==========="+md.getPm().getName());
            for(Menu m : md.getChildren()) {
                System.out.println("    ++" + m.getName());
            }
        }
    }
}
