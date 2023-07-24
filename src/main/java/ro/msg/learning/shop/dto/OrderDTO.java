package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderDTO
{
    // UUID from OrderDetails, Integer for quantity
    private Map<UUID, Integer> productToQuantityMap;
    private LocalDateTime createdAt;
    // delivery address
    private String country;
    private String city;
    private String county;
    private String street;
}
