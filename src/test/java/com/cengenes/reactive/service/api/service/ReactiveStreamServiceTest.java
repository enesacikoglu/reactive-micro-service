package com.cengenes.reactive.service.api.service;

import com.cengenes.reactive.service.api.model.dto.MoneyTransferRequest;
import com.cengenes.reactive.service.api.service.client.CoinApiClient;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import rx.Observable;
import rx.Subscriber;

import java.math.BigInteger;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


public class ReactiveStreamServiceTest {


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ReactiveStreamService reactiveStreamService;

    @Mock
    private CoinApiClient coinApiClient;


    @Captor
    private ArgumentCaptor<MoneyTransferRequest> createShipmentCodeRequestArgumentCaptor;

    @Test
    public void it_should_transfer_money(){


        //Given
        final MoneyTransferRequest transferRequest = new MoneyTransferRequest();
        when(coinApiClient.checkAccount(transferRequest)).thenReturn(Observable.just(Boolean.TRUE));

        //When
        final Observable<Boolean> isTransfered = reactiveStreamService.transferMoney(transferRequest);

        //Then
        verify(coinApiClient).checkAccount(createShipmentCodeRequestArgumentCaptor.capture());

        assertThat(isTransfered).isEqualTo(Observable.just(Boolean.TRUE));

        verifyNoMoreInteractions(coinApiClient);
    }

}