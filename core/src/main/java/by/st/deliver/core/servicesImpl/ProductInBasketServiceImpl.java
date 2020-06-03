package by.st.deliver.core.servicesImpl;


import by.st.deliver.core.dao.OrderRepository;
import by.st.deliver.core.dao.ProductInBasketRepository;
import by.st.deliver.core.entities.OrderStatus;
import by.st.deliver.core.entities.ProductInBasket;
import by.st.deliver.core.mappers.ProductInBasketMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataException;

import by.st.deliver.core.servicesImpl.exceptions.OrderAlreadyReleasedException;
import dto.ProductInBasketCountUpdateMessage;
import dto.ProductInBasketDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ProductInBasketService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductInBasketServiceImpl implements ProductInBasketService {
    @Autowired
    private ProductInBasketRepository productInBasketRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Long addProductInBasket(ProductInBasketDTO productInBasketDTO) {
        Optional<ProductInBasket> optionalProductInBasketDTO = productInBasketRepository.findById(productInBasketDTO.getProductInBasketId());
        if (optionalProductInBasketDTO.isPresent()) {
            throw new DataAlreadyExistException("Product in basket with id " + productInBasketDTO.getProductId() + " already exists");
        }
        ProductInBasket productInBasket = ProductInBasketMapper.INSTANCE.productInBasketDTOToProductInBasket(productInBasketDTO);
        if (productInBasket.getOrder().getStatus().equals(OrderStatus.ONREST)) {
            productInBasket.getOrder().setTotalCost(productInBasket.getOrder().getTotalCost() + (productInBasket.getProduct().getCost() * productInBasket.getCount()));
            orderRepository.save(productInBasket.getOrder());
            return productInBasketDTO.getProductId();
        }
        throw new OrderAlreadyReleasedException("Order with id " + productInBasketDTO.getOrderId() + " already released or complete");
    }

    @Override
    public void removeProductInBasket(Long id) {
        Optional<ProductInBasket> optionalProductInBasket = productInBasketRepository.findById(id);
        optionalProductInBasket.orElseThrow(() -> new NoSuchDataException("There is no product in basket with id " + id));
        ProductInBasket productInBasket = optionalProductInBasket.get();
        productInBasket.getOrder().setTotalCost(productInBasket.getOrder().getTotalCost() - (productInBasket.getCount() * productInBasket.getProduct().getCost()));
        productInBasketRepository.deleteById(id);
    }

    @Override
    public ProductInBasketDTO getProductInBasketById(Long id) {
        Optional<ProductInBasketDTO> productInBasketDTO = Optional.ofNullable(ProductInBasketMapper.INSTANCE.productInBasketToProductInBasketDTO(productInBasketRepository.findByProductInBasketId(id)));
        productInBasketDTO.orElseThrow(() -> new NoSuchDataException("There is no product in basket with id " + id));
        return productInBasketDTO.get();
    }

    @Override
    public List<ProductInBasketDTO> listProductsInBasket(Long orderId) {
        Optional<List<ProductInBasket>> productInBaskets = Optional.ofNullable(productInBasketRepository.findAllByOrderId(orderId));
        productInBaskets.orElseThrow(() -> new NoDataException("There are no products in basket on server"));
        List<ProductInBasketDTO> productInBasketDTOS = productInBaskets.get().stream().map(s -> ProductInBasketMapper.INSTANCE.productInBasketToProductInBasketDTO(s)).collect(Collectors.toList());
        return productInBasketDTOS;
    }

    @Override
    public ProductInBasketDTO updateCountByProductId(ProductInBasketCountUpdateMessage
                                                             productInBasketCountUpdateMessage) {
        Optional<ProductInBasket> optionalProductInBasket = Optional.ofNullable(productInBasketRepository.findByProductInBasketId(productInBasketCountUpdateMessage.getProductId()));
        optionalProductInBasket.orElseThrow(() -> new NoSuchDataException("There is no product in basket with id" + productInBasketCountUpdateMessage.getProductId()));
        ProductInBasket productInBasket = optionalProductInBasket.get();
        Double oldCost = productInBasket.getCount() * productInBasket.getProduct().getCost();
        productInBasket.setCount(productInBasketCountUpdateMessage.getCount());
        productInBasket.getOrder().setTotalCost(productInBasket.getOrder().getTotalCost() - oldCost + (productInBasket.getProduct().getCost() * productInBasket.getCount()));
        productInBasketRepository.save(productInBasket);
        return ProductInBasketMapper.INSTANCE.productInBasketToProductInBasketDTO(productInBasket);
    }
}
