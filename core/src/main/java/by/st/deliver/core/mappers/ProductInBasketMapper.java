package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.ProductInBasket;
import dto.ProductInBasketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.*;

@Mapper
public interface ProductInBasketMapper {
    ProductInBasketMapper INSTANCE = Mappers.getMapper(ProductInBasketMapper.class);

    @Mappings({
            @Mapping(source = "clientId", target = "client.clientId"),
            @Mapping(source = "productId", target = "product.productId")})
    ProductInBasket productInBasketDTOToProductInBasket(ProductInBasketDTO productInBasketDTO);

    @Mappings({
            @Mapping(source = "client.clientId", target = "clientId"),
            @Mapping(source = "product.productId", target = "productId")})
    ProductInBasketDTO productInBasketToProductInBasketDTO(ProductInBasket productInBasket);


}
