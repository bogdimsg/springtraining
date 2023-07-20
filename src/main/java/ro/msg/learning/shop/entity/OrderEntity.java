package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
@Data @NoArgsConstructor @AllArgsConstructor
public class OrderEntity extends BaseEntity
{
    @OneToMany(mappedBy = "orderDId.orders")
    private Set<OrderDetailEntity> orderD;
    @ManyToOne
    private CustomerEntity customer;
    private LocalDateTime createdAt;
    // address
    private String country;
    private String city;
    private String county;
    private String street;
}
