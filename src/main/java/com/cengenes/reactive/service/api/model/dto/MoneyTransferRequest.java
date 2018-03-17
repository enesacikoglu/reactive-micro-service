package com.cengenes.reactive.service.api.model.dto;

import java.math.BigInteger;

public class MoneyTransferRequest {


    private BigInteger price;

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }
}
