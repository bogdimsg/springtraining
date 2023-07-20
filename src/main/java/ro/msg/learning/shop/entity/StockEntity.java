package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.*;
import ro.msg.learning.shop.entity.ids.StockID;

@Entity
@Table(name = "stock")
@Data @NoArgsConstructor @AllArgsConstructor
public class StockEntity
{
    private int quantity;

    @EmbeddedId
    private StockID stockID;
}
