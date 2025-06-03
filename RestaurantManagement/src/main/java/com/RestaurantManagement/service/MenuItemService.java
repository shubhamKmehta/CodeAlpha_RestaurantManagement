package com.RestaurantManagement.service;

import com.RestaurantManagement.model.MenuItem;
import com.RestaurantManagement.repository.MenuItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;

    }

    public MenuItem addMenuItem(@RequestBody MenuItem menuItem){
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> getAllMenuItems(){
        return menuItemRepository.findAll();
    }

}
