package mbt.helper.elastic.service.logic;

import mbt.common.dto.MbtPage;
import mbt.elastic.common.dto.LogModel;
import mbt.elastic.common.dto.LogPersistModel;

public interface ILogService {

    LogModel save(LogPersistModel model);

    MbtPage<LogModel> findByPage(String logType, int page);

}
