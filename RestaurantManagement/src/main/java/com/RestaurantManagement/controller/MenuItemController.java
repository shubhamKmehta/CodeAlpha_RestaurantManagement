package com.RestaurantManagement.controller;

import com.RestaurantManagement.model.MenuItem;
import com.RestaurantManagement.service.MenuItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuItemController {
    private final MenuItemService  menuItemService;

    public MenuItemController(MenuItemService menuItemService){
        this.menuItemService = menuItemService;
    }

    @PostMapping("/add")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem){
        return ResponseEntity.ok(menuItemService.addMenuItem(menuItem));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MenuItem>> getAllMenuItems(){
        return ResponseEntity.ok(menuItemService.getAllMenuItems());
    }

}
