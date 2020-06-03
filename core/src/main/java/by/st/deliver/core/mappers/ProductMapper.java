package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Product;
import dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "restaurant.id", target = "restaurantId")
    ProductDTO productToProductDTO(Product product);

    @Mapping(source = "restaurantId", target = "restaurant.id")
    Product productDtoToProduct(ProductDTO productDTO);
}
