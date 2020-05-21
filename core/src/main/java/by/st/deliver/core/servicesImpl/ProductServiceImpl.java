package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.ProductRepository;
import by.st.deliver.core.entities.Product;
import by.st.deliver.core.mappers.ProductMapper;
import dto.ProductDTO;
import dto.ProductDiscountUpdateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ProductService;

import java.util.*;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.productDtoToProduct(productDTO);
        productRepository.save(product);
        return productDTO;
    }

    @Override
    public void removeProduct(Long id) {
        if (productRepository.findById(id) != null) {
            productRepository.deleteById(id);
        }
    }

    @Override
    public ProductDTO updateProductDiscount(ProductDiscountUpdateMessage productDiscountUpdateMessage) {
        ProductDTO productDTO;
        Product product;
        product = productRepository.findByProductId(productDiscountUpdateMessage.getProductId());
        product.setDiscount(productDiscountUpdateMessage.getDiscount());
        productRepository.save(product);
        productDTO = ProductMapper.INSTANCE.productToProductDTO(product);
        return productDTO;
    }

    @Override
    public ProductDTO getProductByProductId(Long id) {
        return ProductMapper.INSTANCE.productToProductDTO(productRepository.findByProductId(id));
    }

    @Override
    public List<ProductDTO> getProductListByRestaurantId(Long restaurantId) {
        List<Product> products = (List<Product>) productRepository.findAllByRestaurantRestaurantId(restaurantId);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            productDTOS.add(ProductMapper.INSTANCE.productToProductDTO(products.get(i)));
        }
        return productDTOS;
    }
}
