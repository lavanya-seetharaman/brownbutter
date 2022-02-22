package com.blackwinsstudio.webview;

public class Tray {
    private String productColumn;
    private int productQuantity;


    public String getProductColumn() {
        return productColumn;
    }

    public void setProductColumn(String productColumn) {
        this.productColumn = productColumn;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    @Override
    public String toString() {
        return "Tray{" +
                "productColumn='" + productColumn + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
