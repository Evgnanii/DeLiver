package services;

import dto.ProductDTO;
import dto.ProductDiscountUpdateMessage;
import java.util.*;

public interface ProductService {

    public ProductDTO addProduct(ProductDTO productDTO);

    public void removeProduct(Long id);

    ProductDTO updateProductDiscount(ProductDiscountUpdateMessage productDiscountUpdateMessage);

    ProductDTO getProductByProductId(Long id);

    List<ProductDTO> getProductListByRestaurantId(Long restaurantId);

}
