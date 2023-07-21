package ro.msg.learning.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ro.msg.learning.shop.dto.ProductAndCategoryDTO;
import ro.msg.learning.shop.entity.ProductEntity;

@Mapper
public interface ProductAndCategoryMapper
{
    ProductAndCategoryMapper INSTANCE = Mappers.getMapper(ProductAndCategoryMapper.class);

    // product Category mapping
    @Mapping(source = "p.category.id", target = "categoryID")
    @Mapping(source = "p.category.name", target = "categoryName")
    @Mapping(source = "p.category.description", target = "categoryDescription")
    // product mapping
    @Mapping(source = "p.id", target = "productID")
    @Mapping(source = "p.name", target = "productName")
    @Mapping(source = "p.description", target = "productDescription")
    @Mapping(source = "p.price", target = "productPrice")
    @Mapping(source = "p.weight", target = "productWeight")
    @Mapping(source = "p.imageURL", target = "productImageURL")
    ProductAndCategoryDTO toPacDTO(ProductEntity p);

    // product Category mapping
    @Mapping(source = "pacDTO.categoryID", target = "category.id") // or for target "ProductCategoryEntity.id"
    @Mapping(source = "pacDTO.categoryName", target = "category.name")
    @Mapping(source = "pacDTO.categoryDescription", target = "category.description")
    // product mapping
    @Mapping(source = "pacDTO.productID", target = "id")
    @Mapping(source = "pacDTO.productName", target = "name")
    @Mapping(source = "pacDTO.productDescription", target = "description")
    @Mapping(source = "pacDTO.productPrice", target = "price")
    @Mapping(source = "pacDTO.productWeight", target = "weight")
    @Mapping(source = "pacDTO.productImageURL", target = "imageURL")
    ProductEntity toProductEntity(ProductAndCategoryDTO pacDTO);
}
