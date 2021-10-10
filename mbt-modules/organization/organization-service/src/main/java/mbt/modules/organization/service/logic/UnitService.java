package mbt.modules.organization.service.logic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.querydsl.jpa.impl.JPAQueryFactory;
import mbt.common.util.MbtConverter;
import mbt.modules.organization.service.entity.QUnitEntity;
import mbt.modules.organization.service.entity.UnitEntity;
import mbt.modules.organization.service.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organization.common.dto.UnitModel;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UnitService implements IUnitService {

    private final UnitRepository unitRepository;


    private EntityManager em;

    public UnitService(EntityManager em, UnitRepository unitRepository) {
        this.em = em;
        this.unitRepository = unitRepository;
    }

    @Override
    public UnitModel save(UnitModel unitModel) {

        UnitEntity unit = MbtConverter.convertValue(unitModel, UnitEntity.class);
        unit.setName(unitModel.getName());
        unitRepository.save(unit);
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
