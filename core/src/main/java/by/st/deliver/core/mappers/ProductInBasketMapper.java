package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.ProductInBasket;
import dto.ProductInBasketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductInBasketMapper {
    ProductInBasketMapper INSTANCE = Mappers.getMapper(ProductInBasketMapper.class);

    @Mappings({
            @Mapping(source = "orderId", target = "order.orderId"),
            @Mapping(source = "productId", target = "product.productId")})
    ProductInBasket productInBasketDTOToProductInBasket(ProductInBasketDTO productInBasketDTO);

    @Mappings({
            @Mapping(source = "order.orderId", target = "orderId"),
            @Mapping(source = "product.productId", target = "productId")})
    ProductInBasketDTO productInBasketToProductInBasketDTO(ProductInBasket productInBasket);


}
