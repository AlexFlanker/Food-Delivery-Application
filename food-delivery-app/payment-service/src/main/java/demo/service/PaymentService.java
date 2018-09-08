package demo.service;

import demo.domain.Payment;
import org.springframework.util.concurrent.ListenableFuture;

public interface PaymentService {
    Payment savePayment(Payment payment);

    ListenableFuture<AuthorizationResponse> makePayment(Payment payment);

    void updateOrderStatusAfterPayment(String orderId, OrderStatusUpdateMessage orderStatusUpdateMessage);

    Payment getPaymentById(String paymentId);

    Payment getPaymentByOrderId(String orderId);
}
