package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.entity.LocationEntity;
import ro.msg.learning.shop.entity.ProductEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StructureDTO
{
    private LocationEntity location;
    private ProductEntity product;
    private int quantity;
}
