package by.st.deliver.core.servicesImpl;


import by.st.deliver.core.dao.ProductInBasketRepository;
import by.st.deliver.core.entities.ProductInBasket;
import by.st.deliver.core.mappers.ProductInBasketMapper;
import dto.ProductInBasketCountUpdateMessage;
import dto.ProductInBasketDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ProductInBasketService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductInBasketServiceImpl implements ProductInBasketService {
    Logger logger = LoggerFactory.getLogger(ProductInBasketServiceImpl.class);
    @Autowired
    private ProductInBasketRepository productInBasketRepository;

    @Override
    public ProductInBasketDTO addProductInBasket(ProductInBasketDTO productInBasketDTO) {
        logger.debug("ProductInBasketService starts method addProductInBasket");
        productInBasketRepository.save(ProductInBasketMapper.INSTANCE.productInBasketDTOToProductInBasket(productInBasketDTO));
        logger.debug("addProductInBasket operation ended ok");
        return productInBasketDTO;
    }

    @Override
    public void removeProductInBasket(Long id) {
        productInBasketRepository.deleteById(id);
    }

    @Override
    public ProductInBasketDTO getProductInBasketById(Long id) {
        return ProductInBasketMapper.INSTANCE.productInBasketToProductInBasketDTO(productInBasketRepository.findByProductInBasketId(id));
    }

    @Override
    public Iterable<ProductInBasketDTO> listProductsInBasket(Long clientId) {
        List<ProductInBasket> productInBaskets = productInBasketRepository.findAllByClientClientId(clientId);
        List<ProductInBasketDTO> productInBasketDTOS = new ArrayList<>();
        for (int i = 0; i < productInBaskets.size(); i++) {
            productInBasketDTOS.add(ProductInBasketMapper.INSTANCE.productInBasketToProductInBasketDTO(productInBaskets.get(i)));
        }
        return productInBasketDTOS;
    }

    @Override
    public ProductInBasketDTO updateCountByProductId(ProductInBasketCountUpdateMessage productInBasketCountUpdateMessage) {
       ProductInBasket productInBasket = productInBasketRepository.findByProductInBasketId(productInBasketCountUpdateMessage.getProductId());
       productInBasket.setCount(productInBasketCountUpdateMessage.getCount());
        productInBasketRepository.save(productInBasket);

        return ProductInBasketMapper.INSTANCE.productInBasketToProductInBasketDTO(productInBasket);
    }
}
