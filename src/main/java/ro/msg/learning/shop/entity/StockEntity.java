package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.*;
import ro.msg.learning.shop.StockID;

@Entity
@Table(name = "stock")
@Data @NoArgsConstructor @AllArgsConstructor
@IdClass(StockID.class)
public class StockEntity
{
    @ManyToOne @Id
    private ProductEntity product1;
    @ManyToOne @Id
    private LocationEntity location;
    private int quantity;
}
