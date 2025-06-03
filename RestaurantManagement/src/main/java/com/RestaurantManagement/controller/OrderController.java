package com.RestaurantManagement.controller;

import com.RestaurantManagement.model.OrderEntity;
import com.RestaurantManagement.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestParam Long tableId, @RequestBody List<Long> menuItemsId){
        orderService.createorder(tableId,menuItemsId);
        return ResponseEntity.ok("Order successfully saved");
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderEntity>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllorders());
    }

    @GetMapping("/{tableId}/orders/{orderId}")
    public ResponseEntity<OrderEntity> getOrderForaTable(@PathVariable Long tableId,@PathVariable Long orderId){
        return orderService.getOrderForTable(tableId,orderId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }



    @GetMapping("/table/{tableId}")
    public ResponseEntity<List<OrderEntity>> getOrderByTable(@PathVariable Long tableId){
        return ResponseEntity.ok(orderService.getOrdersByTable(tableId));
    }
}
