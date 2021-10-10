package mbt.modules.organization.service.logic;

import organization.common.dto.UnitModel;

import java.util.List;

public interface IUnitService {

    UnitModel save(UnitModel unitModel);

    List<UnitModel> findByName(String name);
}
