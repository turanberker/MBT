package mbt.modules.personel.service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import organization.kafka.consumer.AbstractUnitCreatedConsumer;
import organization.kafka.event.UnitCreatedEvent;

public class SilConsumer extends AbstractUnitCreatedConsumer {

    @Override
    @KafkaListener(topics = TOPIC_NAME, groupId = "SilConsumer", containerFactory = "silConsumerFactory")
    public void consumeMessage(UnitCreatedEvent event) {
        System.out.println("SilConsumer içinde : " + event.getName()+" id: "+event.getId());
    }
}
