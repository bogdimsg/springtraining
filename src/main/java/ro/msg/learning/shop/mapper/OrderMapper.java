package ro.msg.learning.shop.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entity.OrderDetailEntity;
import ro.msg.learning.shop.entity.OrderEntity;

@Mapper
public interface OrderMapper
{
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "oE.orderD.orderDId.product.id", target = "prodIDs")
    @Mapping(source = "oE.orderD.quantity", target = "prodIDs")
    @Mapping(source = "oE.createdAt", target = "createdAt")
    @Mapping(source = "oE.country", target = "country")
    @Mapping(source = "oE.city", target = "city")
    @Mapping(source = "oE.county", target = "county")
    @Mapping(source = "oE.street", target = "street")
    OrderDTO toOrderDTO(OrderEntity oE);

    @AfterMapping
    default void idAfterMapping(OrderEntity orderEntity, @MappingTarget OrderDTO orderDTO)
    {
        orderDTO.getProdIDs().put(
                orderEntity.getOrderD().forEach(
                        (OrderDetailEntity orderDId) -> orderDId.getOrderDId().getOrders().getId()
                ),

                orderEntity.getOrderD().forEach()
        );
    }

    OrderEntity toOrderEntity(OrderDTO oD);
}
