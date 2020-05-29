package services;

import dto.ProductInBasketCountUpdateMessage;
import dto.ProductInBasketDTO;

public interface ProductInBasketService {

    public Long addProductInBasket(ProductInBasketDTO productInBasketDTO);

    public void removeProductInBasket(Long id);

    public ProductInBasketDTO getProductInBasketById(Long id);

    public Iterable<ProductInBasketDTO> listProductsInBasket(Long clientId);

    public ProductInBasketDTO updateCountByProductId(ProductInBasketCountUpdateMessage productInBasketCountUpdateMessage);

}
