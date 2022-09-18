package mbt.modules.organization.service.logic;

import com.fasterxml.jackson.core.type.TypeReference;
import mbt.common.util.MbtConverter;
import mbt.modules.organization.service.entity.QUnitEntity;
import mbt.modules.organization.service.entity.UnitEntity;
import mbt.modules.organization.service.producer.UnitProducer;
import mbt.modules.organization.service.repository.UnitRepository;
import org.springframework.stereotype.Service;
import organization.common.dto.UnitModel;
import organization.kafka.event.UnitCreatedEvent;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UnitService implements IUnitService {

    private final UnitRepository unitRepository;

    private final UnitProducer unitProducer;

    private EntityManager em;

    public UnitService(UnitRepository unitRepository, UnitProducer unitProducer, EntityManager em) {
        this.unitRepository = unitRepository;
        this.unitProducer = unitProducer;
        this.em = em;
    }

    @Override
    public UnitModel save(UnitModel unitModel) {

        UnitEntity unit = MbtConverter.convertValue(unitModel, UnitEntity.class);
        unit.setName(unitModel.getName());
        unitRepository.save(unit);
        UnitCreatedEvent unitCreatedEvent = new UnitCreatedEvent(unit.getId(), unit.getName());
        unitProducer.sendMessage(unitCreatedEvent);
        unitModel.setId(unit.getId());
        return unitModel;
    }

    @Override
    public List<UnitModel> findByName(String name) {
        Iterable<UnitEntity> all = unitRepository.findAll(QUnitEntity.unitEntity.name.likeIgnoreCase(name));

        return MbtConverter.convertValue(all, new TypeReference<>() {
        });
    }
}
