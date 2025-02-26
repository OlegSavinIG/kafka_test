package order.example.controller;

import lombok.RequiredArgsConstructor;
import order.example.model.OrderRequest;
import order.example.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService service;
    @PostMapping
    public void createOrder(@RequestBody String orderRequest){
        service.createOrder(orderRequest);
    }
}
