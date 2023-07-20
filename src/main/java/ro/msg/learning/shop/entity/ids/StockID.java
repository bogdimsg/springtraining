package ro.msg.learning.shop.entity.ids;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import ro.msg.learning.shop.entity.LocationEntity;
import ro.msg.learning.shop.entity.ProductEntity;

@Data
@Embeddable
public class StockID
{
    @ManyToOne
    private ProductEntity product;
    @ManyToOne
    private LocationEntity location;
}
