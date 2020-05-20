package services;

import dto.ProductInBasketCountUpdateMessage;
import dto.ProductInBasketDTO;

import java.util.List;

public interface ProductInBasketService {

    public ProductInBasketDTO addProductInBasket(ProductInBasketDTO productInBasketDTO);

    public void removeProductInBasket(Long id);

    public ProductInBasketDTO getProductInBasketById(Long id);

    public Iterable<ProductInBasketDTO> listProductsInBasket(Long clientId);

    public ProductInBasketDTO updateCountByProductId(ProductInBasketCountUpdateMessage productInBasketCountUpdateMessage);

}
