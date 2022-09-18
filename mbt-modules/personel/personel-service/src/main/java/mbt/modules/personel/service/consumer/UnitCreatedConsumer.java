package mbt.modules.personel.service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import organization.kafka.consumer.AbstractUnitCreatedConsumer;
import organization.kafka.event.UnitCreatedEvent;

public class UnitCreatedConsumer extends AbstractUnitCreatedConsumer {
    @Override
    @KafkaListener(topics = TOPIC_NAME, groupId = "group1", containerFactory = "unitCreateConsumerFactory")
    public void consumeMessage(UnitCreatedEvent event) {
        System.out.println("Personel içinde : " + event.getName()+" id: "+event.getId());
    }
}
