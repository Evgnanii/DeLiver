package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.OrderRepository;
import by.st.deliver.core.dao.ProductRepository;
import by.st.deliver.core.entities.Order;
import by.st.deliver.core.entities.Product;
import by.st.deliver.core.entities.ProductInBasket;
import by.st.deliver.core.mappers.ProductMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataException;

import dto.ProductDTO;
import dto.ProductDiscountUpdateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Long changeProductCount(Long orderId, Long productId, Integer count) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        orderOptional.orElseThrow(() -> new NoSuchDataException("There is no order with id " + orderId));
        Order order = orderOptional.get();
        ProductInBasket productInBasket = order.getProductInBasket()
                .stream()
                .filter(productInBasket1 -> productInBasket1.getProduct().getId() == productId)
                .findAny()
                .orElseThrow(() -> new NoSuchDataException("There is no product with id " + productId));
        order.getProductInBasket().removeIf(productInBasket1 -> productInBasket1.getProduct().getId() == productId);
        productInBasket.setCount(count);
        order.getProductInBasket().add(productInBasket);
        orderRepository.save(order);
        return productId;
    }

    @Override
    public Long addProductToOrder(ProductDTO productDTO, Long orderId, Integer count) {
        Order order = orderRepository.findOrderById(orderId).orElseThrow(() -> new NoSuchDataException("There is no order with id " + orderId));
        System.out.println(productDTO.toString());
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDTO);
        order.getProductInBasket().add(new ProductInBasket(order, product, count));
        order.setTotalCost(order.getTotalCost() + (product.getCost() * count));
        orderRepository.save(order);
        return productDTO.getId();
    }

    @Override
    public void removeProductFromOrder(Long orderId, Long productId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        optionalOrder.orElseThrow(() -> new NoSuchDataException("Order with id " + orderId + " no exists"));
        Order order = optionalOrder.get();
        ProductInBasket productInBasket = order.getProductInBasket()
                .stream()
                .filter(productInBasket1 -> productInBasket1.getProduct().getId() == productId)
                .findAny().orElseThrow(() -> new NoSuchDataException("There is no product with id " + productId + "in this order"));
        order.getProductInBasket().remove(productInBasket);
        order.setTotalCost(order.getTotalCost() - (productInBasket.getProduct().getCost() * productInBasket.getCount()));
        orderRepository.save(order);
    }


    @Override
    public Long addProduct(ProductDTO productDTO) {
        Optional<Product> product = productRepository.findById(productDTO.getId());
        if (product.isPresent()) {
            throw new DataAlreadyExistException("Product  id " + product.get().getId() + " already exists");
        }
        productRepository.save(ProductMapper.INSTANCE.productDtoToProduct(productDTO));
        return productDTO.getId();
    }

    @Override
    public void addProductsToOrder(List<ProductDTO> productDTOList, Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        orderOptional.orElseThrow(() -> new NoSuchDataException("There is no order with id " + orderId));
        List<Product> products = productDTOList.stream().map(productDTO -> ProductMapper.INSTANCE.productDtoToProduct(productDTO)).collect(Collectors.toList());
        Order order = orderOptional.get();
        products.stream().map(product -> order.getProductInBasket().add(new ProductInBasket(order, product, 1)));
        orderRepository.save(order);
    }

    @Override
    public void removeProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        product.orElseThrow(() -> new NoSuchDataException("There is no product with id " + id));
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO updateProductDiscount(ProductDiscountUpdateMessage productDiscountUpdateMessage) {
        Optional<Product> optionalProduct = productRepository.findProductById(productDiscountUpdateMessage.getProductId());
        optionalProduct.orElseThrow(() -> new NoSuchDataException("There is no product with id " + productDiscountUpdateMessage.getProductId()));
        Product product = optionalProduct.get();
        product.setDiscount(productDiscountUpdateMessage.getDiscount());
        productRepository.save(product);
        ProductDTO productDTO = ProductMapper.INSTANCE.productToProductDTO(product);
        return productDTO;
    }

    @Override
    public ProductDTO getProductByProductId(Long id) {
        Optional<ProductDTO> productDTO = Optional.ofNullable(ProductMapper.INSTANCE.productToProductDTO(productRepository.findProductById(id).get()));
        productDTO.orElseThrow(() -> new NoSuchDataException("There is no product with id " + id));
        return productDTO.get();
    }

    @Override
    public List<ProductDTO> getProductListByRestaurantId(Long restaurantId, Integer page) {
        Optional<List<Product>> products = Optional.ofNullable(productRepository.findAllByRestaurantId(restaurantId, PageRequest.of(page, 5)));
        products.orElseThrow(() -> new NoDataException("There are no product in restaurant with id " + restaurantId));
        List<ProductDTO> productDTOS = products.get().stream().map(s -> ProductMapper.INSTANCE.productToProductDTO(s)).collect(Collectors.toList());
        return productDTOS;
    }


}
