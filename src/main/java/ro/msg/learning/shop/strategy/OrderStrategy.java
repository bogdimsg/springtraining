package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.entity.OrderEntity;

import java.util.Map;
import java.util.UUID;

public interface OrderStrategy
{
    OrderEntity createOrder(OrderEntity order, Map<UUID, Integer> productToQuantityMap);
}
