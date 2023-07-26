package ro.msg.learning.shop.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.UUID;

@MappedSuperclass
@Data
public abstract class BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
