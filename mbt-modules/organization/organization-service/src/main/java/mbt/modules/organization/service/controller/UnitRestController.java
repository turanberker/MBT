package mbt.modules.organization.service.controller;

import mbt.modules.organization.service.logic.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import organization.common.dto.UnitModel;
import organization.common.service.UnitFeignClient;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/unit")
public class UnitRestController implements UnitFeignClient {

    @Autowired
    private UnitService unitService;

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnitModel>save (@RequestBody @Valid UnitModel unitModel){
        UnitModel save = unitService.save(unitModel);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping(path = "/findByName/{name}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UnitModel>> findByName(@PathVariable(name = "name") String name){
        List<UnitModel> byName = unitService.findByName(name);
        return new ResponseEntity<>(byName, HttpStatus.CREATED);
    }

}
