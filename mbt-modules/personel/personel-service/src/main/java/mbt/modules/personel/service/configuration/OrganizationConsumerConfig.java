package mbt.modules.personel.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import organization.kafka.configuration.BaseOrganizationConsumerConfiguration;
import organization.kafka.event.UnitCreatedEvent;


@Configuration
public class OrganizationConsumerConfig extends BaseOrganizationConsumerConfiguration {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UnitCreatedEvent> silConsumerFactory(){
        return getUnitCreatedFactory("SilConsumer");
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UnitCreatedEvent> unitCreateConsumerFactory(){
        return getUnitCreatedFactory("group1");
    }
}
