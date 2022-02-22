package com.blackwinsstudio.webview;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrdersModel {
    public int id;
    public int parent_id;
    public String status;
    public String currency;
    public String version;
    public boolean prices_include_tax;
    public Date date_created;
    public Date date_modified;
    public String discount_total;
    public String discount_tax;
    public String shipping_total;
    public String shipping_tax;
    public String cart_tax;
    public String total;
    public String total_tax;
    public int customer_id;
    public String order_key;
    public Billing billing;
    public Shipping shipping;
    public String payment_method;
    public String payment_method_title;
    public String transaction_id;
    public String customer_ip_address;
    public String customer_user_agent;
    public String created_via;
    public String customer_note;
    public Date date_completed;
    public Date date_paid;
    public String cart_hash;
    public String number;
    public List<MetaData> meta_data;
    public List<LineItem> line_items;
    public ArrayList tax_lines;
    public List<ShippingLine> shipping_lines;
    public ArrayList fee_lines;
    public ArrayList coupon_lines;
    public ArrayList refunds;
    public Date date_created_gmt;
    public Date date_modified_gmt;
    public Date date_completed_gmt;
    public Date date_paid_gmt;
    public String currency_symbol;
    public Links _links;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
class Billing{
    public String first_name;
    public String last_name;
    public String company;
    public String address_1;
    public String address_2;
    public String city;
    public String state;
    public String postcode;
    public String country;
    public String email;
    public String phone;
}

class Shipping{
    public String first_name;
    public String last_name;
    public String company;
    public String address_1;
    public String address_2;
    public String city;
    public String state;
    public String postcode;
    public String country;
    public String phone;
}

class MetaData{
    public int id;
    public String key;
    public String value;
    public String display_key;
    public String display_value;
}

class LineItem{
    public int id;
    public String name;
    public int product_id;
    public int variation_id;
    public int quantity;
    public String tax_class;
    public String subtotal;
    public String subtotal_tax;
    public String total;
    public String total_tax;
    public ArrayList taxes;
    public List<MetaData> meta_data;
    public String sku;
    public int price;
    public String parent_name;
}

class ShippingLine{
    public int id;
    public String method_title;
    public String method_id;
    public String instance_id;
    public String total;
    public String total_tax;
    public ArrayList taxes;
    public List<MetaData> meta_data;
}

class Self{
    public String href;
}

class Collection{
    public String href;
}

class Customer{
    public String href;
}

class Links{
    public List<Self> self;
    public List<Collection> collection;
    public List<Customer> customer;
}

