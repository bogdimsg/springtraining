package ro.msg.learning.shop;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.entity.LocationEntity;
import ro.msg.learning.shop.entity.ProductEntity;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StockID implements Serializable
{
    private ProductEntity product;
    private LocationEntity location;
}
