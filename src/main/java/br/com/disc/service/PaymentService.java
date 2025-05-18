package br.com.disc.service;

import br.com.disc.model.dto.CardPaymentDTO;
import br.com.disc.model.dto.PixPaymentDTO;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final UserService userService;

    public Payment sendCardPayment(CardPaymentDTO cardPaymentDTO) throws MPException, MPApiException {
        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put("x-idempotency-key", "test");

        MPRequestOptions requestOptions = MPRequestOptions.builder()
                .customHeaders(customHeaders)
                .build();

        MercadoPagoConfig.setAccessToken("TEST-4639695764642601-092420-c60d7e95264f4f6565777d6a310e9f37-130379252");

        PaymentCreateRequest paymentCreateRequest =
                PaymentCreateRequest.builder()
                        .transactionAmount(cardPaymentDTO.getTransactionAmount())
                        .token(cardPaymentDTO.getToken())
                        .description(cardPaymentDTO.getDescription())
                        .installments(cardPaymentDTO.getInstallments())
                        .paymentMethodId(cardPaymentDTO.getPaymentMethodId())
                        .payer(
                                PaymentPayerRequest.builder()
                                        .email(userService.getLoggedUser().getEmail())
                                        .identification(
                                                IdentificationRequest.builder()
                                                        .type(cardPaymentDTO.getPayer().getIdentification().getType())
                                                        .number(cardPaymentDTO.getPayer().getIdentification().getNumber())
                                                        .build())
                                        .build())
                        .build();

        PaymentClient client = new PaymentClient();

        try {
            return client.create(paymentCreateRequest, requestOptions);
        } catch (MPException | MPApiException e) {
            log.info(e.getMessage());
            throw e;
        }
    }

    public Payment sendPixPayment(PixPaymentDTO pixPaymentDTO) throws MPException, MPApiException {
        MercadoPagoConfig.setAccessToken("TEST-4639695764642601-092420-c60d7e95264f4f6565777d6a310e9f37-130379252");

        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put("x-idempotency-key", "test");

        MPRequestOptions requestOptions = MPRequestOptions.builder()
                .customHeaders(customHeaders)
                .build();

        PaymentClient client = new PaymentClient();

        PaymentCreateRequest paymentCreateRequest =
                PaymentCreateRequest.builder()
                        .transactionAmount(pixPaymentDTO.getTransactionAmount())
                        .description("Título do produto")
                        .paymentMethodId("pix")
                        .dateOfExpiration(OffsetDateTime.now(ZoneOffset.UTC))
                        .payer(
                                PaymentPayerRequest.builder()
                                        .email(userService.getLoggedUser().getEmail())
                                        .firstName(pixPaymentDTO.getPayer().getName())
                                        .identification(
                                                IdentificationRequest
                                                        .builder()
                                                        .type(pixPaymentDTO.getPayer().getIdentification().getType())
                                                        .number(pixPaymentDTO.getPayer().getIdentification().getNumber())
                                                        .build())
                                        .build())
                        .build();

        return client.create(paymentCreateRequest, requestOptions);
    }
}
