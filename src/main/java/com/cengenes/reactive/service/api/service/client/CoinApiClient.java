package com.cengenes.reactive.service.api.service.client;

import com.cengenes.reactive.service.api.model.dto.MoneyTransferRequest;
import org.springframework.stereotype.Component;
import rx.Observable;

import java.math.BigInteger;
import java.util.Objects;

@Component
public class CoinApiClient {
    public Observable<Boolean> checkAccount(MoneyTransferRequest request) {
        return Observable.just(Objects.isNull(request.getPrice()) ? Boolean.FALSE : request.getPrice().compareTo(BigInteger.ZERO) > 0);
    }
}
