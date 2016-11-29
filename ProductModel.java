package com.meluha.monlashsolutions.meluha;

/**
 * Created by Monlash Solutions on 11/19/2016.
 */

public class ProductModel {


    String product_name;
    String product_image;
    String product_id;
    String product_fullprice;
    String product_offerprice;
    String product_description;

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_image() {
        return product_image;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_fullprice() {
        return product_fullprice;
    }

    public String getProduct_offerprice() {
        return product_offerprice;
    }

    public String getProduct_description() {
        return product_description;
    }


    public ProductModel() {
    }
    public ProductModel(String product_name, String product_image, String product_id, String product_fullprice, String product_offerprice, String product_description) {
        this.product_name = product_name;
        this.product_image = product_image;
        this.product_id = product_id;
        this.product_fullprice = product_fullprice;
        this.product_offerprice = product_offerprice;
        this.product_description = product_description;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setProduct_fullprice(String product_fullprice) {
        this.product_fullprice = product_fullprice;
    }

    public void setProduct_offerprice(String product_offerprice) {
        this.product_offerprice = product_offerprice;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }
}
