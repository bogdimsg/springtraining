package ro.msg.learning.shop.service;

import ro.msg.learning.shop.entity.ProductEntity;

import java.util.Collection;
import java.util.UUID;

public interface ProductService
{
    void createProduct(ProductEntity product);
    ProductEntity getProduct(UUID id);
    Collection<ProductEntity> getProducts();
    void updateProduct(ProductEntity product);
    void deleteProduct(UUID id);
}
