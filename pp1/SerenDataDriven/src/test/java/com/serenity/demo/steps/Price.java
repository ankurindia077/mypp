/**
 * @Copyright Copyright (C) 2016 General Electric Company. All rights reserved.
 * @author  Ankur Chaudhry
 * @version 1.0
 * @since   2016-07-05
 */

package com.serenity.demo.steps;

public class Price {
    private String product;
    private Integer price;
    private String currency;

    public Price(String product, Integer price, String currency) {
        this.product = product;
        this.price = price;
        this.currency = currency;
    }

    public String getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
