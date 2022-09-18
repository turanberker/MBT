package organization.kafka.consumer;

import mbt.kafka.consumer.IConsumer;
import organization.kafka.costants.KafkaEventConstants;
import organization.kafka.event.UnitCreatedEvent;

public abstract class AbstractUnitCreatedConsumer implements IConsumer<UnitCreatedEvent> {

    protected static final String TOPIC_NAME = KafkaEventConstants.UNIT_CREATED_EVENT;
    protected static final String CONTAINER_FACTORY_NAME = "unitCreatedFactory";
}
