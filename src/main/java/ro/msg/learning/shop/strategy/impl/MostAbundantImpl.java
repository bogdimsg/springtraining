package ro.msg.learning.shop.strategy.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.entity.OrderEntity;
import ro.msg.learning.shop.service.LocationService;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.strategy.OrderStrategy;

import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class MostAbundantImpl implements OrderStrategy
{
    private final LocationService locationService;
    private final ProductService productService;

    @Override
    public OrderEntity createOrder(OrderEntity order, Map<UUID, Integer> productToQuantityMap)
    {
        return null;
    }
}
