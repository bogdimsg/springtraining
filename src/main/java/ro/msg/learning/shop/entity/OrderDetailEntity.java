package ro.msg.learning.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orderDetails")
@Data @NoArgsConstructor @AllArgsConstructor
public class OrderDetailEntity extends BaseEntity
{
    @ManyToOne
    private OrderEntity orders;
    @ManyToOne
    private ProductEntity product;
    @ManyToOne
    private LocationEntity shippedFrom;
    private int quantity;
}
