package com.prolian.test.framework.helpers;

import lombok.Data;

@Data
public class Products {

private String type;
private String productURL;

public Products(String type,String productURL ) {

    this.type=type;
    this.productURL=productURL;
}

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
