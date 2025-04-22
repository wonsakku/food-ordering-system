package com.food.ordering.system.order.service.dataaccess.customer.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name = "order_customer_m_view", schema = "customer") // 초기 예제에서는 view 를 사용
@Entity
public class CustomerEntity {

    @Id
    private UUID id;


}
