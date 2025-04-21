package com.food.ordering.system.kafka.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class KafkaMessageHelper {

    // callback 메서드가 지금은 로그를 남기는 것 뿐이지만
    // saga & outbox 패턴을 구현하면 이 로직이 중요해짐.
    // 복원력이 높은 시스템을 얻기 위해 이 코드를 리팩토링할 것임.
    public <T> ListenableFutureCallback<SendResult<String, T>> getKafkaCallback(String responseTopicName,
                                                                                T avroModel,
                                                                                String orderId,
                                                                                String avroModelName
                                                                                ) {
        return new ListenableFutureCallback<SendResult<String, T>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Error while sending " + avroModelName +
                        "message {} to topic {}", avroModel.toString(), responseTopicName, ex);
            }

            @Override
            public void onSuccess(SendResult<String, T> result) {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Received successful response from Kafka for order id : {} " +
                                "Topic: {} Partition: {} Offset: {} Timestamp: {}",
                        orderId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp()
                );
            }
        };
    }

}
