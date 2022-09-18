package mbt.modules.organization.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import organization.kafka.costants.KafkaEventConstants;
import organization.kafka.event.UnitCreatedEvent;

@Component
public class UnitProducer {


    private String topicName = KafkaEventConstants.UNIT_CREATED_EVENT;

    @Autowired
    private KafkaTemplate<String, UnitCreatedEvent> kafkaTemplate;

    public void sendMessage(UnitCreatedEvent createdUnit) {
        kafkaTemplate.send(topicName, createdUnit);
    }
}
