package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.ProductRepository;
import by.st.deliver.core.entities.Product;
import by.st.deliver.core.mappers.ProductMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataException;

import dto.ProductDTO;
import dto.ProductDiscountUpdateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

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
    public void removeProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        product.orElseThrow(() -> new NoSuchDataException("There is no product with id " + id));
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO updateProductDiscount(ProductDiscountUpdateMessage productDiscountUpdateMessage) {
        Optional<Product> optionalProduct = Optional.ofNullable(productRepository.findProductById(productDiscountUpdateMessage.getProductId()));
        optionalProduct.orElseThrow(() -> new NoSuchDataException("There is no product with id " + productDiscountUpdateMessage.getProductId()));
        Product product = optionalProduct.get();
        product.setDiscount(productDiscountUpdateMessage.getDiscount());
        productRepository.save(product);
        ProductDTO productDTO = ProductMapper.INSTANCE.productToProductDTO(product);
        return productDTO;
    }

    @Override
    public ProductDTO getProductByProductId(Long id) {
        Optional<ProductDTO> productDTO = Optional.ofNullable(ProductMapper.INSTANCE.productToProductDTO(productRepository.findProductById(id)));
        productDTO.orElseThrow(() -> new NoSuchDataException("There is no product with id " + id));
        return productDTO.get();
    }

    @Override
    public List<ProductDTO> getProductListByRestaurantId(Long restaurantId) {
        Optional<List<Product>> products = Optional.ofNullable(productRepository.findAllByRestaurantId(restaurantId));
        products.orElseThrow(() -> new NoDataException("There are no product in restaurant with id " + restaurantId));
        List<ProductDTO> productDTOS = products.get().stream().map(s -> ProductMapper.INSTANCE.productToProductDTO(s)).collect(Collectors.toList());
        return productDTOS;
    }
}
