package by.st.deliver.rest.controllers;

import dto.ProductDTO;
import dto.ProductDiscountUpdateMessage;
import dto.ProductInBasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{restaurant_id}")
    public ResponseEntity<List<ProductDTO>> getAllRestaurantProducts(@PathVariable("restaurant_id") Long restaurantId) {
        List<ProductDTO> productDTOList = (List<ProductDTO>) productService.getProductListByRestaurantId(restaurantId);
        return new ResponseEntity<>(productDTOList, new HttpHeaders(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<ProductDTO> updateProductDiscount(@RequestBody @Valid ProductDiscountUpdateMessage productDiscountUpdateMessage) {
        ProductDTO productDTO = productService.updateProductDiscount(productDiscountUpdateMessage);
        return new ResponseEntity<>(productDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody @Valid ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return new ResponseEntity<>(productDTO, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<ProductInBasketDTO> deleteProduct(@PathVariable("product_id") Long productId){
        productService.removeProduct(productId);
        return new ResponseEntity<> (new  HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}
