package ro.msg.learning.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.*;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.service.OrderService;
import java.util.Collection;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private LocationServiceImpl locationService;

    public boolean checkLocation(OrderEntity order, LocationEntity loc)
    {
        // checking if the location has the things in stock
        for (OrderDetailEntity orderDetailEntity : order.getOrderDetailEntities())
            for (StockEntity st : loc.getStock())
                if (!st.getStockID().getProduct().equals(orderDetailEntity.getOrderDetailId().getProduct())
                        || st.getQuantity() < orderDetailEntity.getQuantity())
                    return false;
        // updating the quantity in the stock
        for (OrderDetailEntity orderDetailEntity : order.getOrderDetailEntities())
            for (StockEntity st : loc.getStock())
                if (st.getStockID().getProduct().equals(orderDetailEntity.getOrderDetailId().getProduct()))
                    st.setQuantity(st.getQuantity() - orderDetailEntity.getQuantity());
        return true;
    }

    public boolean forLocations(OrderEntity order)
    {
        for (LocationEntity loc : locationService.getLocation())
            if (checkLocation(order, loc))
                return true;
        return false;
    }

    @Override
    public void createOrder(OrderEntity order)
    {
        if (forLocations(order))
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

    public CustomerEntity getCustomer(UUID id)
    {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        return customerService.getCustomer(id);
    }
}
