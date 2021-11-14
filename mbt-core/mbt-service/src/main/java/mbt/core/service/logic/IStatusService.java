package mbt.core.service.logic;

import mbt.common.dto.StatusModel;
import mbt.core.service.entity.StatusEntity;

public interface IStatusService {

    Long save(StatusModel status);
}
