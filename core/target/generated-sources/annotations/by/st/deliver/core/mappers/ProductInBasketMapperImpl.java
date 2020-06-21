package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Order;
import by.st.deliver.core.entities.Product;
import by.st.deliver.core.entities.ProductInBasket;
import dto.ProductInBasketDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-21T19:54:49+0300",
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

        productInBasketDTO.setProductId( productInBasketProductId( productInBasket ) );
        productInBasketDTO.setOrderId( productInBasketOrderId( productInBasket ) );
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

        product.setId( productInBasketDTO.getProductId() );

        return product;
    }

    protected Order productInBasketDTOToOrder(ProductInBasketDTO productInBasketDTO) {
        if ( productInBasketDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( productInBasketDTO.getOrderId() );

        return order;
    }

    private Long productInBasketProductId(ProductInBasket productInBasket) {
        if ( productInBasket == null ) {
            return null;
        }
        Product product = productInBasket.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long productInBasketOrderId(ProductInBasket productInBasket) {
        if ( productInBasket == null ) {
            return null;
        }
        Order order = productInBasket.getOrder();
        if ( order == null ) {
            return null;
        }
        Long id = order.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
