package mbt.elastic.common.feign;

import mbt.common.dto.MbtPage;
import mbt.elastic.common.dto.LogModel;
import mbt.elastic.common.dto.LogPersistModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "logFeignClient", url = "localhost:8100", path = "/log/")
public interface LogFeignClient {

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogModel> save(@RequestBody LogPersistModel logModel);

    @GetMapping(path = "/findAll/{logType}/{pageNumber}")
    ResponseEntity<MbtPage<LogModel>> find(@PathVariable("logType") String logType, @PathVariable("pageNumber") Integer pageNumber);
}
