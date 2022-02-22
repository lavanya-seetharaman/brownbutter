package com.blackwinsstudio.webview;

public class OrderedItemModel {
    public int order_id;
    public String status;
    public int product_id;
    public int quantity;
    public String options;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "OrderedItemModel{" +
                "order_id=" + order_id +
                ", status='" + status + '\'' +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", options='" + options + '\'' +
                '}';
    }
}
