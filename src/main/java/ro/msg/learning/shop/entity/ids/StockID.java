package ro.msg.learning.shop.entity.ids;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import ro.msg.learning.shop.entity.LocationEntity;
import ro.msg.learning.shop.entity.ProductEntity;

@Data
@Embeddable
public class StockID
{
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductEntity product;
    @ManyToOne(cascade = CascadeType.ALL)
    private LocationEntity location;
}
