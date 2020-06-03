package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Product;
import by.st.deliver.core.entities.Restaurant;
import dto.ProductDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-02T23:05:02+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setRestaurantId( productRestaurantId( product ) );
        productDTO.setId( product.getId() );
        productDTO.setName( product.getName() );
        productDTO.setCost( product.getCost() );
        productDTO.setRating( product.getRating() );
        productDTO.setWeight( product.getWeight() );
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
        product.setId( productDTO.getId() );
        product.setName( productDTO.getName() );
        product.setCost( productDTO.getCost() );
        product.setRating( productDTO.getRating() );
        product.setWeight( productDTO.getWeight() );
        product.setDiscount( productDTO.getDiscount() );

        return product;
    }

    private Long productRestaurantId(Product product) {
        if ( product == null ) {
            return null;
        }
        Restaurant restaurant = product.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        Long id = restaurant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Restaurant productDTOToRestaurant(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setId( productDTO.getRestaurantId() );

        return restaurant;
    }
}
