package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Order;
import by.st.deliver.core.entities.Product;
import by.st.deliver.core.entities.ProductInBasket;
import dto.ProductInBasketDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-28T14:16:15+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class ProductInBasketMapperImpl implements ProductInBasketMapper {

    @Override
    public ProductInBasket productInBasketDTOToProductInBasket(ProductInBasketDTO productInBasketDTO) {
        if ( productInBasketDTO == null ) {
            return null;
        }

        ProductInBasket productInBasket = new ProductInBasket();

        productInBasket.setProduct( productInBasketDTOToProduct( productInBasketDTO ) );
        productInBasket.setOrder( productInBasketDTOToOrder( productInBasketDTO ) );
        productInBasket.setProductInBasketId( productInBasketDTO.getProductInBasketId() );
        if ( productInBasketDTO.getCount() != null ) {
            productInBasket.setCount( productInBasketDTO.getCount().intValue() );
        }

        return productInBasket;
    }

    @Override
    public ProductInBasketDTO productInBasketToProductInBasketDTO(ProductInBasket productInBasket) {
        if ( productInBasket == null ) {
            return null;
        }

        ProductInBasketDTO productInBasketDTO = new ProductInBasketDTO();

        productInBasketDTO.setProductId( productInBasketProductProductId( productInBasket ) );
        productInBasketDTO.setOrderId( productInBasketOrderOrderId( productInBasket ) );
        productInBasketDTO.setProductInBasketId( productInBasket.getProductInBasketId() );
        if ( productInBasket.getCount() != null ) {
            productInBasketDTO.setCount( productInBasket.getCount().longValue() );
        }

        return productInBasketDTO;
    }

    protected Product productInBasketDTOToProduct(ProductInBasketDTO productInBasketDTO) {
        if ( productInBasketDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( productInBasketDTO.getProductId() );

        return product;
    }

    protected Order productInBasketDTOToOrder(ProductInBasketDTO productInBasketDTO) {
        if ( productInBasketDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderId( productInBasketDTO.getOrderId() );

        return order;
    }

    private Long productInBasketProductProductId(ProductInBasket productInBasket) {
        if ( productInBasket == null ) {
            return null;
        }
        Product product = productInBasket.getProduct();
        if ( product == null ) {
            return null;
        }
        Long productId = product.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    private Long productInBasketOrderOrderId(ProductInBasket productInBasket) {
        if ( productInBasket == null ) {
            return null;
        }
        Order order = productInBasket.getOrder();
        if ( order == null ) {
            return null;
        }
        Long orderId = order.getOrderId();
        if ( orderId == null ) {
            return null;
        }
        return orderId;
    }
}
