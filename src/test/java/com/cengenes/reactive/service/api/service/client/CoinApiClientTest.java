package com.cengenes.reactive.service.api.service.client;

import com.cengenes.reactive.service.api.model.dto.MoneyTransferRequest;
import com.cengenes.reactive.service.api.service.ReactiveStreamService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class CoinApiClientTest {


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CoinApiClient coinApiClient;

    @Spy
    private TestSubscriber<Boolean> subscriber;


    @Test
    public void it_should_return_true_when_money_exist_in_account(){


        //Given
        final MoneyTransferRequest request = new MoneyTransferRequest();
        request.setPrice(BigInteger.TEN);


        //When
        final Observable<Boolean> isMoneyAvailableObservable = coinApiClient.checkAccount(request);

        isMoneyAvailableObservable.subscribe(subscriber);

        //Then
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertValue(Boolean.TRUE);        }


    @Test
    public void it_should_return_false_when_money_not_exist_in_account(){


        //Given
        final MoneyTransferRequest request = new MoneyTransferRequest();


        //When
        final Observable<Boolean> isMoneyAvailableObservable = coinApiClient.checkAccount(request);

        isMoneyAvailableObservable.subscribe(subscriber);


        //Then
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertValue(Boolean.FALSE);


    }
}