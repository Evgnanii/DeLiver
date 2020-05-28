package by.st.deliver.core.servicesImpl;


import by.st.deliver.core.dao.ProductInBasketRepository;
import by.st.deliver.core.entities.ProductInBasket;
import by.st.deliver.core.mappers.ProductInBasketMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataExceptionQ;
import dto.ProductInBasketCountUpdateMessage;
import dto.ProductInBasketDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ProductInBasketService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductInBasketServiceImpl implements ProductInBasketService {
    @Autowired
    private ProductInBasketRepository productInBasketRepository;

    @Override
    public Long addProductInBasket(ProductInBasketDTO productInBasketDTO) {
        if (productInBasketRepository.findById(productInBasketDTO.getProductInBasketId()) != null) {
            throw new DataAlreadyExistException("Product in basket with id " + productInBasketDTO.getProductId() + " already exists");
        }
        productInBasketRepository.save(ProductInBasketMapper.INSTANCE.productInBasketDTOToProductInBasket(productInBasketDTO));

        return productInBasketDTO.getProductId();
    }

    @Override
    public void removeProductInBasket(Long id) {
        if (productInBasketRepository.findById(id) == null) {
            throw new NoSuchDataExceptionQ("There is no product in basket with id " + id);
        }
        productInBasketRepository.deleteById(id);
    }

    @Override
    public ProductInBasketDTO getProductInBasketById(Long id) {
        ProductInBasketDTO productInBasketDTO = ProductInBasketMapper.INSTANCE.productInBasketToProductInBasketDTO(productInBasketRepository.findByProductInBasketId(id));
        if (productInBasketDTO == null) {
            throw new NoSuchDataExceptionQ("There is no product in basket with id " + id);
        }
        return productInBasketDTO;
    }

    @Override
    public List<ProductInBasketDTO> listProductsInBasket(Long orderId) {
        List<ProductInBasket> productInBaskets = productInBasketRepository.findAllByOrderOrderId(orderId);
        if (productInBaskets.isEmpty()) {
            throw new NoDataException("There are no products in basket on server");
        }
        List<ProductInBasketDTO> productInBasketDTOS = productInBaskets.stream().map(s -> ProductInBasketMapper.INSTANCE.productInBasketToProductInBasketDTO(s)).collect(Collectors.toList());
        return productInBasketDTOS;
    }

    @Override
    public ProductInBasketDTO updateCountByProductId(ProductInBasketCountUpdateMessage
                                                             productInBasketCountUpdateMessage) {
        ProductInBasket productInBasket = productInBasketRepository.findByProductInBasketId(productInBasketCountUpdateMessage.getProductId());
        if (productInBasket == null) {
            throw new NoSuchDataExceptionQ("There is no product in basket with id" + productInBasketCountUpdateMessage.getProductId());
        }
        productInBasket.setCount(productInBasketCountUpdateMessage.getCount());
        productInBasketRepository.save(productInBasket);

        return ProductInBasketMapper.INSTANCE.productInBasketToProductInBasketDTO(productInBasket);
    }
}
