package mbt.helper.elastic.service.controller;

import mbt.common.dto.MbtPage;
import mbt.elastic.common.dto.LogModel;
import mbt.elastic.common.dto.LogPersistModel;
import mbt.elastic.common.feign.LogFeignClient;
import mbt.helper.elastic.service.logic.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/log/")
public class LogController implements LogFeignClient {

    @Autowired
    private LogService service;

    @Override
    public ResponseEntity<LogModel> save(@RequestBody LogPersistModel logModel) {
        return new ResponseEntity<>(service.save(logModel), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MbtPage<LogModel>> find(String logType, Integer pageNumber) {
        return new ResponseEntity<>(service.findByPage(logType, pageNumber), HttpStatus.OK);
    }
}
