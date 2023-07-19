package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.*;
import ro.msg.learning.shop.StockID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stock")
@Data @NoArgsConstructor @AllArgsConstructor
@IdClass(StockID.class)
public class StockEntity extends BaseEntity
{
    private int quantity;
    @EmbeddedId @ManyToOne
    private StockID stockID;
}
