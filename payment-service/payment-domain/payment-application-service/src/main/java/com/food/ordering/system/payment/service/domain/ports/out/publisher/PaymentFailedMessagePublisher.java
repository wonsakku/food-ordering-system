package com.food.ordering.system.payment.service.domain.ports.out.publisher;

import com.food.ordering.system.domain.event.DomainEvent;
import com.food.ordering.system.payment.service.domain.event.PaymentFailedEvent;

public interface PaymentFailedMessagePublisher extends DomainEvent<PaymentFailedEvent> {
}
