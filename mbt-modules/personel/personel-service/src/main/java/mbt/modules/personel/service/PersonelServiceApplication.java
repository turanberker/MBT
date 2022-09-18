package mbt.modules.personel.service;

import mbt.modules.personel.service.consumer.SilConsumer;
import mbt.modules.personel.service.consumer.UnitCreatedConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class PersonelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonelServiceApplication.class, args);
    }

    @Bean
    public UnitCreatedConsumer unitCreatedConsumer() {
        return new UnitCreatedConsumer();
    }


    @Bean
    public SilConsumer silConsumer() {
        return new SilConsumer();
    }
}
