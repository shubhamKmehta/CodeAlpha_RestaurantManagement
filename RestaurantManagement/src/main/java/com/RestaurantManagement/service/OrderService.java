package com.RestaurantManagement.service;

import com.RestaurantManagement.model.MenuItem;
import com.RestaurantManagement.model.OrderEntity;
import com.RestaurantManagement.model.OrderItem;
import com.RestaurantManagement.model.RestaurantTable;
import com.RestaurantManagement.repository.MenuItemRepository;
import com.RestaurantManagement.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final MenuItemRepository menuItemRepository;

    public OrderService(OrderRepository orderRepository, MenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;

    }

    public OrderEntity createorder(Long tableId, List<Long> menuItemsId){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setStatus("Pending");
        orderEntity.setTable(new RestaurantTable());
        orderEntity.getTable().setId(tableId);

        List<OrderItem> items = new ArrayList<>();
        double total =0;

        for(Long itemsid : menuItemsId){
            MenuItem menuItem =  menuItemRepository.findById(itemsid).orElseThrow();
            OrderItem orderItem = new OrderItem();
            orderItem.setMenuItem(menuItem);
            orderItem.setQuantity(1);
            orderItem.setPrice(menuItem.getPrice());
            orderItem.setOrder(orderEntity);
            items.add(orderItem);

        }
        orderEntity.setItems(items);
        orderEntity.setTotalAmount(total);
        return orderRepository.save(orderEntity);
    }

    public List<OrderEntity> getAllorders(){
        return orderRepository.findAll();
    }

    public Optional<OrderEntity> getOrderForTable(Long tableId,Long orderId){
        return orderRepository.findById(orderId)
                .filter(order -> order.getTable() != null && order.getTable().getId().equals(tableId));
    }

    public List<OrderEntity> getOrdersByTable(Long tableId){
        return orderRepository.findByTableId(tableId);
    }

}
