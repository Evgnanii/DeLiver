package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.ProductRepository;
import by.st.deliver.core.entities.Product;
import by.st.deliver.core.mappers.ProductMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataExceptionQ;
import dto.ProductDTO;
import dto.ProductDiscountUpdateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Long addProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDTO);
        if (product != null) {
            throw new DataAlreadyExistException("Product  id " + product.getProductId() + " already exists");
        }
        productRepository.save(product);
        return productDTO.getProductId();
    }

    @Override
    public void removeProduct(Long id) {
        if (productRepository.findById(id) == null) {
            throw new NoSuchDataExceptionQ("There is no product with id " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO updateProductDiscount(ProductDiscountUpdateMessage productDiscountUpdateMessage) {
        Product product = productRepository.findProductByProductId(productDiscountUpdateMessage.getProductId());
        if (product == null) {
            throw new NoSuchDataExceptionQ("There is no product with id " + productDiscountUpdateMessage.getProductId());
        }
        product.setDiscount(productDiscountUpdateMessage.getDiscount());
        productRepository.save(product);
        ProductDTO productDTO = ProductMapper.INSTANCE.productToProductDTO(product);
        return productDTO;
    }

    @Override
    public ProductDTO getProductByProductId(Long id) {
        ProductDTO productDTO = ProductMapper.INSTANCE.productToProductDTO(productRepository.findProductByProductId(id));
        if (productDTO == null) {
            throw new NoSuchDataExceptionQ("There is no product with id " + id);
        }
        return productDTO;
    }

    @Override
    public List<ProductDTO> getProductListByRestaurantId(Long restaurantId) {
        List<Product> products = productRepository.findAllByRestaurantRestaurantId(restaurantId);
        if (products.isEmpty()) {
            throw new NoDataException("There are no product in restaurant with id " + restaurantId);
        }
        List<ProductDTO> productDTOS = products.stream().map(s -> ProductMapper.INSTANCE.productToProductDTO(s)).collect(Collectors.toList());
        return productDTOS;
    }
}
