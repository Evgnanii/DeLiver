package services;

import dto.ProductDTO;
import dto.ProductDiscountUpdateMessage;

import java.util.List;

public interface ProductService {

    Long changeProductCount(Long orderId, Long productId, Integer count);

    Long addProductToOrder(ProductDTO productDTO, Long orderId, Integer count);

    void removeProductFromOrder(Long orderId, Long productId);

    public Long addProduct(ProductDTO productDTO);

    public void addProductsToOrder(List<ProductDTO> productDTOList, Long orderId);

    public void removeProduct(Long id);

    ProductDTO updateProductDiscount(ProductDiscountUpdateMessage productDiscountUpdateMessage);

    ProductDTO getProductByProductId(Long id);

    List<ProductDTO> getProductListByRestaurantId(Long restaurantId, Integer page);

}
