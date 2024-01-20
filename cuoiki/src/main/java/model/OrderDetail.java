package model;

public class OrderDetail {
    private int id;
    private int productId;
    private int orderId;

    public OrderDetail(){}

    public OrderDetail(int id, int productId, int orderId) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
    }

    public OrderDetail(int productId, int orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getproductId() {
        return productId;
    }

    public void setproductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
