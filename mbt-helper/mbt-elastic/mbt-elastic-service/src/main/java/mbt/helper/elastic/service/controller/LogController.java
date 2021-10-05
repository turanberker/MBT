package mbt.helper.elastic.service.controller;

import mbt.common.dto.MbtPage;
import mbt.elastic.common.dto.LogModel;
import mbt.elastic.common.dto.LogPersistModel;
import mbt.elastic.common.feign.LogFeignClient;
import mbt.helper.elastic.service.logic.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/log/")
public class LogController implements LogFeignClient {

    @Autowired
    private ILogService service;

    @Override
    public ResponseEntity<LogModel> save(@RequestBody LogPersistModel logModel) {
        return new ResponseEntity<>(service.save(logModel), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MbtPage<LogModel>> find(String logType, Integer pageNumber) {
        return new ResponseEntity<>(service.findByPage(logType, pageNumber), HttpStatus.OK);
    }

    @GetMapping(path = "/test")
    public String test() {
        return "Hello World";
    }
}
