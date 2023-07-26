package ro.msg.learning.shop.strategy.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.entity.*;
import ro.msg.learning.shop.entity.ids.OrderDetailID;
import ro.msg.learning.shop.service.impl.LocationServiceImpl;
import ro.msg.learning.shop.service.impl.ProductServiceImpl;
import ro.msg.learning.shop.strategy.OrderStrategy;

import java.util.*;

@RequiredArgsConstructor
public class SingleLocationImpl implements OrderStrategy
{
    private final LocationServiceImpl locationService;
    private final ProductServiceImpl productService;

    private boolean checkSingleLocation(LocationEntity location, Map<UUID, Integer> productToQuantityMap)
    {
        boolean checker;
        for (UUID id : productToQuantityMap.keySet())
        {
            checker = false;
            for (StockEntity stock : location.getStock())
                if (stock.getStockID().getProduct().getId().equals(id) && stock.getQuantity() >= productToQuantityMap.get(id))
                {
                    checker = true;
                    break;
                }
            if (!checker)
                return false;
        }
        return true;
    }

    private LocationEntity findSingleLocation(Map<UUID, Integer> productToQuantityMap)
    {
        for (LocationEntity location : locationService.getLocation())
            if (checkSingleLocation(location, productToQuantityMap))
                return location;
        return null;
    }

    private void updateStockAtLocation(LocationEntity location, Map<UUID, Integer> productToQuantityMap, OrderEntity order)
    {
        for (UUID id : productToQuantityMap.keySet())
            for (StockEntity stock : location.getStock())
                if (stock.getStockID().getProduct().getId().equals(id) && stock.getQuantity() >= productToQuantityMap.get(id))
                {
                    stock.setQuantity(stock.getQuantity() - productToQuantityMap.get(id));
                    break;
                }
    }

    public OrderEntity createOrder(OrderEntity order, Map<UUID, Integer> productToQuantityMap)
    {
        LocationEntity location = findSingleLocation(productToQuantityMap);
        if (location != null)
        {
            OrderEntity newOrder = new OrderEntity(order.getCreatedAt(), location.getCountry(), location.getCity(), location.getCounty(), location.getStreet());
            List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();
            OrderDetailEntity orderDetail = new OrderDetailEntity();
            for (UUID id : productToQuantityMap.keySet())
            {
                orderDetail.setOrderDetailId(new OrderDetailID(newOrder, productService.getProduct(id)));
                orderDetail.setShippedFrom(location);
                orderDetail.setQuantity(productToQuantityMap.get(id));

                orderDetailEntities.add(orderDetail);
            }
            newOrder.setOrderDetailEntities(orderDetailEntities);
            newOrder.setCustomer(null);

            updateStockAtLocation(location, productToQuantityMap, order);
            return newOrder;
        }
        return null;
    }
}
