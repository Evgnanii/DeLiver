package services;

import dto.ProductDTO;
import dto.ProductDiscountUpdateMessage;

import java.util.List;

public interface ProductService {

    public Long changeProductCount(Long orderId, Long productId, Integer count);

    public Long addProductToOrder(ProductDTO productDTO, Long orderId, Integer count);

    public void removeProductFromOrder(Long orderId, Long productId);

    public Long addProduct(ProductDTO productDTO);

    public void addProductsToOrder(List<ProductDTO> productDTOList, Long orderId);

    public void removeProduct(Long id);

    public ProductDTO updateProductDiscount(ProductDiscountUpdateMessage productDiscountUpdateMessage);


    public List<ProductDTO> getProductListByRestaurantId(Long restaurantId, Integer page);

}
