// Order Detail ID
package ro.msg.learning.shop.entity.ids;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import ro.msg.learning.shop.entity.OrderEntity;
import ro.msg.learning.shop.entity.ProductEntity;

@Data
@Embeddable
public class OrderDetailID
{
    @ManyToOne
    private OrderEntity orders;
    @ManyToOne
    private ProductEntity product;
}
