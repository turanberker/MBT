package mbt.helper.elastic.service.logic;

import com.fasterxml.jackson.core.type.TypeReference;
import mbt.common.dto.MbtPage;
import mbt.common.util.MbtConverter;
import mbt.elastic.common.dto.LogModel;
import mbt.elastic.common.dto.LogPersistModel;
import mbt.helper.elastic.service.document.LogDocument;
import mbt.helper.elastic.service.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class LogService {

    @Autowired
    private  LogRepository repository;

    public LogModel save(LogPersistModel model) {
        LogDocument logDocument = MbtConverter.convertValue(model, LogDocument.class);
        logDocument.setDate(new Date());
        logDocument = repository.save(logDocument);

        return MbtConverter.convertValue(logDocument, LogModel.class);

    }

    public MbtPage<LogModel> findByPage(String logType, int page) {

        Pageable pageable = PageRequest.of(page, 10, Sort.unsorted());
        Page<LogDocument> byLogType = repository.findByLogType(logType, pageable);

        return MbtConverter.get().convertValue(byLogType, new TypeReference<>() {
        });
    }


}
