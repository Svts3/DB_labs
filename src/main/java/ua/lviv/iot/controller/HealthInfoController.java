package ua.lviv.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.dto.HealthInfoDTO;
import ua.lviv.iot.dto.assembler.HealthInfoDTOAssembler;
import ua.lviv.iot.model.HealthInfo;
import ua.lviv.iot.service.HealthInfoService;

@RestController
@RequestMapping("/api/healthInfo")
public class HealthInfoController {

    private HealthInfoService healthInfoService;
    private HealthInfoDTOAssembler healthInfoDTOAssembler;

    @Autowired
    public HealthInfoController(HealthInfoService healthInfoService,
            HealthInfoDTOAssembler healthInfoDTOAssembler) {
        this.healthInfoService = healthInfoService;
        this.healthInfoDTOAssembler = healthInfoDTOAssembler;
    }

    @GetMapping("/")
    public ResponseEntity<CollectionModel<HealthInfoDTO>> findAll() {
        List<HealthInfo> healthInfos = healthInfoService.findAll();
        CollectionModel<HealthInfoDTO> collectionModel = healthInfoDTOAssembler
                .toCollectionModel(healthInfos);
        return new ResponseEntity<CollectionModel<HealthInfoDTO>>(collectionModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthInfoDTO> findById(@PathVariable("id") Long id) {
        HealthInfo healthInfo = healthInfoService.findById(id);
        HealthInfoDTO collectionModel = healthInfoDTOAssembler.toModel(healthInfo);
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }

    @GetMapping("/getAvgHrtRate")
    public ResponseEntity<Integer> getAverageHeartbeatRate() {
        return new ResponseEntity<>(healthInfoService.getAverageHeartbeatRate(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<HealthInfoDTO> addHealthInfo(@RequestBody HealthInfo healthInfo) {
        HealthInfo healthInfo2 = healthInfoService.save(healthInfo);
        HealthInfoDTO collectionModel = healthInfoDTOAssembler.toModel(healthInfo2);
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthInfoDTO> updateHealthInfo(@PathVariable("id") Long id,
            @RequestBody HealthInfo healthInfo) {
        HealthInfo healthInfo2 = healthInfoService.update(healthInfo, id);
        HealthInfoDTO collectionModel = healthInfoDTOAssembler.toModel(healthInfo2);
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HealthInfoDTO> deleteHealthInfo(@PathVariable("id") Long id) {
        HealthInfo healthInfo2 = healthInfoService.deleteById(id);
        HealthInfoDTO collectionModel = healthInfoDTOAssembler.toModel(healthInfo2);
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }

}
