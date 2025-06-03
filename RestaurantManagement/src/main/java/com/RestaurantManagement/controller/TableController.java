package com.RestaurantManagement.controller;

import com.RestaurantManagement.model.RestaurantTable;
import com.RestaurantManagement.repository.MenuItemRepository;
import com.RestaurantManagement.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController {

    private final TableService tableService;
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping("/add")
    public ResponseEntity<RestaurantTable> addTable(@RequestBody RestaurantTable restaurantTable){
        return ResponseEntity.ok(tableService.addTable(restaurantTable));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RestaurantTable>> getAllTables(){
        return ResponseEntity.ok(tableService.getAllTables());
    }
}
