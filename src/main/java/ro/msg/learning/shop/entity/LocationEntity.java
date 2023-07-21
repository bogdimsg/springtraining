package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "locations")
@Data @NoArgsConstructor @AllArgsConstructor
public class LocationEntity extends BaseEntity implements Serializable
{
    @OneToMany(mappedBy = "stockID.location")
    private Set<StockEntity> stock;
    @OneToMany(mappedBy = "shippedFrom")
    private Set<OrderDetailEntity> orderD;
    private String name;
    // address
    private String country;
    private String city;
    private String county;
    private String street;

    public LocationEntity(String name, String country, String city, String county, String street)
    {
        this.name = name;
        this.country = country;
        this.city = city;
        this.county = county;
        this.street = street;
    }
}
