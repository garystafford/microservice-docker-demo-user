package com.user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Widget {
    @Id
    private String id;

    private String productId;
    private String name;
    private String color;
    private String size;
    private Integer cost;
    private String preview;

    public Widget() {
    }

    public Widget(String productId, String name, String color,
                  String size, Integer cost, String preview) {
        this.productId = productId;
        this.name = name;
        this.color = color;
        this.size = size;
        this.cost = cost;
        this.preview = preview;
    }

    public String getproductId() {
        return productId;
    }

    public void setproductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
