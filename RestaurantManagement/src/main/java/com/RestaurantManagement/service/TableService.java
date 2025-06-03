package com.RestaurantManagement.service;

import com.RestaurantManagement.model.RestaurantTable;
import com.RestaurantManagement.repository.MenuItemRepository;
import com.RestaurantManagement.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public RestaurantTable addTable(RestaurantTable restaurantTable){
        return tableRepository.save(restaurantTable);
    }

    public List<RestaurantTable> getAllTables(){
        return tableRepository.findAll();
    }

}
