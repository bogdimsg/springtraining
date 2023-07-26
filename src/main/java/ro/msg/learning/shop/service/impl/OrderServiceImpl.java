package ro.msg.learning.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.configuration.StrategyConfiguration;
import ro.msg.learning.shop.entity.*;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.service.OrderService;
import ro.msg.learning.shop.strategy.impl.SingleLocationImpl;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private LocationServiceImpl locationService;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private final StrategyConfiguration strategy = new StrategyConfiguration();

    @Override
    public OrderEntity createOrder(OrderEntity order, Map<UUID, Integer> productToQuantityMap)
    {
        // this one doesn't work and I have yet to figure out why
//        return orderRepo.save(strategy.createOrder(order, productToQuantityMap));
        return orderRepo.save(new SingleLocationImpl(locationService, productService).createOrder(order, productToQuantityMap));
    }

    @Override
    public OrderEntity getOrder(UUID id)
    {
        return orderRepo.getReferenceById(id);
    }

    @Override
    public Collection<OrderEntity> getOrders()
    {
        return orderRepo.findAll();
    }

    @Override
    public void updateOrder(OrderEntity order)
    {
        orderRepo.save(order);
    }

    @Override
    public void deleteOrder(UUID id)
    {
        orderRepo.deleteById(id);
    }
}
