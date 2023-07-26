package ro.msg.learning.shop.service;

import ro.msg.learning.shop.entity.OrderEntity;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface OrderService
{
    OrderEntity createOrder(OrderEntity product, Map<UUID, Integer> productToQuantityMap);
    OrderEntity getOrder(UUID id);
    Collection<OrderEntity> getOrders();
    void updateOrder(OrderEntity product);
    void deleteOrder(UUID id);
}
