package dto;

public class ProductInBasketDTO {
    private Long productInBasketId;
    private Long clientId;
    private Long productId;

    public Long getProductInBasketId() {
        return productInBasketId;
    }

    public void setProductInBasketId(Long productInBasketId) {
        this.productInBasketId = productInBasketId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    private Long count;
}
