package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductEntity extends BaseEntity
{
    @OneToMany(mappedBy = "product1")
    private Set<StockEntity> stock;
    @OneToMany(mappedBy = "product2")
    private Set<OrderDetailEntity> orderD;
    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    @ManyToOne
    private ProductCategoryEntity category;
    private String imageURL;
}
