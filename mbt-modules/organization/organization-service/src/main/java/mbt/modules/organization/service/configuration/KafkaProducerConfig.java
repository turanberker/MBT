package mbt.modules.organization.service.configuration;

import mbt.kafka.config.BaseKafkaConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import organization.kafka.event.UnitCreatedEvent;

@Configuration
public class KafkaProducerConfig extends BaseKafkaConfiguration {

    @Bean
    public KafkaTemplate<String, UnitCreatedEvent> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
