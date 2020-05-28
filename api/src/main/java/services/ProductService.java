package services;

import dto.ProductDTO;
import dto.ProductDiscountUpdateMessage;

import java.util.List;

public interface ProductService {

    public Long addProduct(ProductDTO productDTO);

    public void removeProduct(Long id);

    ProductDTO updateProductDiscount(ProductDiscountUpdateMessage productDiscountUpdateMessage);

    ProductDTO getProductByProductId(Long id);

    List<ProductDTO> getProductListByRestaurantId(Long restaurantId);

}
