package by.st.deliver.rest.controllers;


import dto.ProductInBasketCountUpdateMessage;
import dto.ProductInBasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ProductInBasketService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products_in_basket/")
public class ProductInBasketController {

    @Autowired
    ProductInBasketService productInBasketService;

    @GetMapping("/{client_id}")
    public ResponseEntity<List<ProductInBasketDTO>> getAllClientProducts(@PathVariable("client_id") Long clientId) {
        List<ProductInBasketDTO> productInBasketDTOList = (List<ProductInBasketDTO>) productInBasketService.listProductsInBasket(clientId);
        return new ResponseEntity<>(productInBasketDTOList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/question/{product_in_basket_id}")
    public ResponseEntity<ProductInBasketDTO> getProductsByProductInBasketId(@PathVariable("product_in_basket_id") Long productId) {
        ProductInBasketDTO productInBasketDTO = productInBasketService.getProductInBasketById(productId);
        return new ResponseEntity<>(productInBasketDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductInBasketDTO> addProduct(@RequestBody @Valid ProductInBasketDTO productInBasketDTO) {
        productInBasketService.addProductInBasket(productInBasketDTO);
        return new ResponseEntity<>(productInBasketDTO, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<ProductInBasketDTO> deleteProductFromBasket(@PathVariable("product_id") Long productId) {
        productInBasketService.removeProductInBasket(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping()
    public ResponseEntity<ProductInBasketDTO> updateTitlesByDepartmentId(@RequestBody @Valid ProductInBasketCountUpdateMessage message) {
        ProductInBasketDTO productInBasketDTO =  productInBasketService.updateCountByProductId(message);
        return new ResponseEntity<>(productInBasketDTO, HttpStatus.OK);
    }
}
