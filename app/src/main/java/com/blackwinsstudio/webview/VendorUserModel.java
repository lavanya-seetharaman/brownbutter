package com.blackwinsstudio.webview;
import java.util.ArrayList;
import java.util.List;

class Meta {
    private Pagination pagination;
    public Pagination getPagination() {
        return pagination;
    }
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
class Pagination {
    private Integer page;
    private Integer pageSize;
    private Integer pageCount;
    private Integer total;
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
}

 class VendorDetails {
    private Integer id;
    private VendorUserAtrributes attributes;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public VendorUserAtrributes getAttributes() {
        return attributes;
    }
    public void setAttributes(VendorUserAtrributes attributes) {
        this.attributes = attributes;
    }
}
 class VendorUserAtrributes {
    private String vendor_email;
    private String createdAt;
    private String updatedAt;
    private String publishedAt;
    public String getVendorEmail() {
        return vendor_email;
    }
    public void setVendorEmail(String vendorEmail) {
        this.vendor_email = vendorEmail;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getPublishedAt() {
        return publishedAt;
    }
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
public class VendorUserModel {
    private List<VendorDetails> data = new ArrayList<VendorDetails>();
    private Meta meta;
    public List<VendorDetails> getData() {
        return data;
    }
    public void setData(List<VendorDetails> data) {
        this.data = data;
    }
    public Meta getMeta() {
        return meta;
    }
    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
