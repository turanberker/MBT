package mbt.modules.organization.service.logic;

import mbt.common.util.MbtConverter;
import mbt.modules.organization.service.entity.UnitEntity;
import mbt.modules.organization.service.repository.UnitRepository;
import org.springframework.stereotype.Service;
import organization.common.dto.UnitModel;

@Service
public class UnitService implements IUnitService {

    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public UnitModel save(UnitModel unitModel) {

        UnitEntity unit = new MbtConverter().convertValue(unitModel, UnitEntity.class);
        unit.setName(unitModel.getName());
        unitRepository.save(unit);
        unitModel.setId(unit.getId());
        return unitModel;
    }
}
