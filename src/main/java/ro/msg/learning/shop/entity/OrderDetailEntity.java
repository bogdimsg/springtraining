package ro.msg.learning.shop.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.entity.ids.OrderDetailID;

@Entity
@Table(name = "orderDetails")
@Data @NoArgsConstructor @AllArgsConstructor
public class OrderDetailEntity
{
    @EmbeddedId
    private OrderDetailID orderDId;
    @ManyToOne
    private LocationEntity shippedFrom;
    private int quantity;
}
