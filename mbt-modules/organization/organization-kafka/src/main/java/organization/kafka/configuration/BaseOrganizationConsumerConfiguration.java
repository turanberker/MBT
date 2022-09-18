package organization.kafka.configuration;

import mbt.kafka.config.BaseKafkaConfiguration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import organization.kafka.event.UnitCreatedEvent;

public class BaseOrganizationConsumerConfiguration extends BaseKafkaConfiguration {

    protected ConcurrentKafkaListenerContainerFactory<String, UnitCreatedEvent> getUnitCreatedFactory(String groupId) {
        ConcurrentKafkaListenerContainerFactory<String, UnitCreatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerConfigFactory(groupId, UnitCreatedEvent.class));
        return factory;
    }
}
