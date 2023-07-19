package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "locations")
@Data @NoArgsConstructor @AllArgsConstructor
public class LocationEntity extends BaseEntity
{
    @OneToMany(mappedBy = "location")
    private Set<StockEntity> stock;
    @OneToMany(mappedBy = "shippedFrom")
    private Set<OrderDetailEntity> orderD;
    private String name;
    // address
    private String country;
    private String city;
    private String county;
    private String street;
}
