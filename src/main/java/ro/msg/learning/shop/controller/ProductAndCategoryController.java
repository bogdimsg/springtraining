package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductAndCategoryDTO;
import ro.msg.learning.shop.entity.ProductEntity;
import ro.msg.learning.shop.mapper.ProductAndCategoryMapper;
import ro.msg.learning.shop.service.ProductAndCategoryService;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ProductAndCategoryController
{
    @Autowired
    private ProductAndCategoryService pacS;

    @PostMapping(value = "/products-and-categories/post")
    public ResponseEntity<Object> createProduct(@RequestBody ProductAndCategoryDTO pac)
    {
        pacS.createProduct(ProductAndCategoryMapper.INSTANCE.toProductEntity(pac));
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/products-and-categories/{id}", "/products-and-categories/get/{id}"})
    public ResponseEntity<Object> getProduct(@PathVariable("id") UUID id)
    {
        return new ResponseEntity<>(ProductAndCategoryMapper.INSTANCE.toPacDTO(pacS.getProduct(id)), HttpStatus.OK);
    }

    @RequestMapping(value = "/products-and-categories")
    public ResponseEntity<Object> getProducts()
    {
        Collection<ProductEntity> prods = pacS.getProducts();
        prods.forEach(ProductAndCategoryMapper.INSTANCE::toPacDTO);
        return new ResponseEntity<>(prods, HttpStatus.OK);
    }

    @PutMapping(value = "/products-and-categories/put/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductAndCategoryDTO pac)
    {
        pacS.updateProduct(ProductAndCategoryMapper.INSTANCE.toProductEntity(pac));
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/products-and-categories/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") UUID id)
    {
        pacS.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
}
