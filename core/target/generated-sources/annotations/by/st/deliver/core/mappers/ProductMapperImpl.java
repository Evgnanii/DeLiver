package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Product;
import by.st.deliver.core.entities.Restaurant;
import dto.ProductDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-28T14:16:15+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setRestaurantId( productRestaurantRestaurantId( product ) );
        productDTO.setProductId( product.getProductId() );
        productDTO.setProductName( product.getProductName() );
        productDTO.setCost( product.getCost() );
        productDTO.setProductRating( product.getProductRating() );
        productDTO.setProductWeight( product.getProductWeight() );
        productDTO.setDiscount( product.getDiscount() );

        return productDTO;
    }

    @Override
    public Product productDtoToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setRestaurant( productDTOToRestaurant( productDTO ) );
        product.setProductId( productDTO.getProductId() );
        product.setProductName( productDTO.getProductName() );
        product.setCost( productDTO.getCost() );
        product.setProductRating( productDTO.getProductRating() );
        product.setProductWeight( productDTO.getProductWeight() );
        product.setDiscount( productDTO.getDiscount() );

        return product;
    }

    private Long productRestaurantRestaurantId(Product product) {
        if ( product == null ) {
            return null;
        }
        Restaurant restaurant = product.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        Long restaurantId = restaurant.getRestaurantId();
        if ( restaurantId == null ) {
            return null;
        }
        return restaurantId;
    }

    protected Restaurant productDTOToRestaurant(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantId( productDTO.getRestaurantId() );

        return restaurant;
    }
}
