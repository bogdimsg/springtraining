package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerEntity extends BaseEntity
{
    @OneToMany(mappedBy = "customer")
    private Set<OrderEntity> orderE;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;
}
