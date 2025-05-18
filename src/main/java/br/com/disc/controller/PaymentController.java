package br.com.disc.controller;

import br.com.disc.model.dto.CardPaymentDTO;
import br.com.disc.model.dto.OngoingTestAnswerDTO;
import br.com.disc.model.dto.PixPaymentDTO;
import br.com.disc.service.PaymentService;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/card")
    public ResponseEntity<Payment> sendCardPayment(@RequestBody CardPaymentDTO paymentCreateRequest) throws MPException, MPApiException {
        Payment response = paymentService.sendCardPayment(paymentCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/pix")
    public ResponseEntity<Payment> sendPixPayment(@RequestBody PixPaymentDTO paymentCreateRequest) throws MPException, MPApiException {
        Payment response = paymentService.sendPixPayment(paymentCreateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
