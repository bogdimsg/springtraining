package ro.msg.learning.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.OrderEntity;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.service.OrderService;

import java.util.Collection;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepo;

    @Override
    public void createOrder(OrderEntity order)
    {
        orderRepo.save(order);
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
