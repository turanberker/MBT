package mbt.core.service.logic;

import mbt.common.dto.StatusModel;
import mbt.common.util.MbtConverter;
import mbt.core.service.entity.StatusEntity;
import mbt.core.service.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatusService implements IStatusService {

    @Autowired
    private StatusRepository repository;

    @Override
    public Long save(StatusModel status) {
        StatusEntity statusEntity = MbtConverter.convertValue(status, StatusEntity.class);
        statusEntity = repository.save(statusEntity);
        return statusEntity.getId();
    }
}
