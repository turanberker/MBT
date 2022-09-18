package mbt.modules.organization.service;

import mbt.modules.organization.service.producer.UnitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import organization.kafka.event.UnitCreatedEvent;

@SpringBootApplication
public class OrganizationServiceApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(OrganizationServiceApplication.class, args);
    }

    @Autowired
    private UnitProducer producer;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for (long i = 0; i < 5; i++) {
            UnitCreatedEvent unitCreatedEvent = new UnitCreatedEvent();
            unitCreatedEvent.setId(i);
            unitCreatedEvent.setName("Unit" + i);
            producer.sendMessage(unitCreatedEvent);


        }

    }
}
