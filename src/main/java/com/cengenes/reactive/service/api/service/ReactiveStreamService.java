package com.cengenes.reactive.service.api.service;

import com.cengenes.reactive.service.api.model.dto.MoneyTransferRequest;
import com.cengenes.reactive.service.api.service.client.CoinApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;


@Service
public class ReactiveStreamService {

    @Autowired
    private CoinApiClient coinApiClient;

    public Observable<Boolean> transferMoney(MoneyTransferRequest moneyTransferRequest) {
        return coinApiClient.checkAccount(moneyTransferRequest);
    }
}
