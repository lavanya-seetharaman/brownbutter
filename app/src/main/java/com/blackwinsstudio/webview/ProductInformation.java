package com.blackwinsstudio.webview;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class ProductInformation {
    public int id;
    public String name;
    public String slug;
    public String permalink;
    public Date date_created;
    public Date date_created_gmt;
    public Date date_modified;
    public Date date_modified_gmt;
    public String type;
    public String status;
    public boolean featured;
    public String catalog_visibility;
    public String description;
    public String short_description;
    public String sku;
    public String price;
    public String regular_price;
    public String sale_price;
    public Date date_on_sale_from;
    public Date date_on_sale_from_gmt;
    public Date date_on_sale_to;
    public Date date_on_sale_to_gmt;
    public boolean on_sale;
    public boolean purchasable;
    public int total_sales;
    public boolean virtual;
    public boolean downloadable;
    public List<Object>  downloads;
    public int download_limit;
    public int download_expiry;
    public String external_url;
    public String button_text;
    public String tax_status;
    public String tax_class;
    public boolean manage_stock;
    public int stock_quantity;
    public String backorders;
    public boolean backorders_allowed;
    public boolean backordered;
    public String low_stock_amount;
    public boolean sold_individually;
    public String weight;
    public Dimensions dimensions;
    public boolean shipping_required;
    public boolean shipping_taxable;
    public String shipping_class;
    public int shipping_class_id;
    public boolean reviews_allowed;
    public String average_rating;
    public int rating_count;
    public List<Object>  upsell_ids;
    public List<Object>  cross_sell_ids;
    public int parent_id;
    public String purchase_note;
    public List<Category> categories;
    public List<Object>  tags;
    public List<Image> images;
    public List<Attribute> attributes;
    public List<String> default_attributes;
    public List<String> variations;
    public List<String> grouped_products;
    public int menu_order;
    public String price_html;
    public List<Integer> related_ids;
    public List<MetaData> meta_data;
    public String stock_status;
    public Links _links;

    public class Dimensions{
        public String length;
        public String width;
        public String height;
    }

    public class Category{
        public int id;
        public String name;
        public String slug;
    }

    public class Image{
        public int id;
        public Date date_created;
        public Date date_created_gmt;
        public Date date_modified;
        public Date date_modified_gmt;
        public String src;
        public String name;
        public String alt;
    }
    public class Attribute{
        public int id;
        public String name;
        public int position;
        public boolean visible;
        public boolean variation;
        public List<String> options;
    }

    public class MetaData{
        public int id;
        public String key;
        public String value;
    }

    public class Self{
        public String href;
    }

    public class Collection{
        public String href;
    }
    /*public class Value{
        public String _0;
        public String shipping_policy;
        public String refund_policy;
        public String cancellation_policy;
    }*/
    public class Links{
        public List<Self> self;
        public List<Collection> collection;
    }

}
