package com.blackwinsstudio.webview;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AttributesModel  {
    public int id;
    public String name;
    public String slug;
    String description;
    int menuOrder;
    String count;
    ArrayList<_links> links;

    public List<AttributesModel> getAttributesModelList() {
        return attributesModelList;
    }

    public void setAttributesModelList(List<AttributesModel> attributesModelList) {
        this.attributesModelList = attributesModelList;
    }

    List<AttributesModel> attributesModelList;


    public class _links{
        ArrayList<Self> self;
        ArrayList<Collect> collection;

        public ArrayList<Self> getSelf() {
            return self;
        }

        public void setSelf(ArrayList<Self> self) {
            this.self = self;
        }

        public ArrayList<Collect> getCollection() {
            return collection;
        }

        public void setCollection(ArrayList<Collect> collection) {
            this.collection = collection;
        }
    }

    public class Self{
        String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    public class Collect{
        String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ArrayList<_links> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<_links> links) {
        this.links = links;
    }
}
