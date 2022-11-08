package ua.lviv.iot.controller;

import java.util.List;
import java.util.Map;

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

import ua.lviv.iot.dto.PropertyInfoDTO;
import ua.lviv.iot.dto.assembler.PropertyInfoDTOAssembler;
import ua.lviv.iot.model.PropertyInfo;
import ua.lviv.iot.service.PropertyInfoService;

@RestController
@RequestMapping("/api/propertyInfo")
public class PropertyInfoController {

    private PropertyInfoService propertyInfoService;
    private PropertyInfoDTOAssembler propertyInfoDTOAssembler;

    @Autowired
    public PropertyInfoController(PropertyInfoService propertyInfoService,
            PropertyInfoDTOAssembler propertyInfoDTOAssembler) {
        this.propertyInfoService = propertyInfoService;
        this.propertyInfoDTOAssembler = propertyInfoDTOAssembler;
    }

    @GetMapping("/")
    public ResponseEntity<CollectionModel<PropertyInfoDTO>> findAll() {
        List<PropertyInfo> propertyInfos = propertyInfoService.findAll();
        CollectionModel<PropertyInfoDTO> collectionModel = propertyInfoDTOAssembler
                .toCollectionModel(propertyInfos);
        return new ResponseEntity<CollectionModel<PropertyInfoDTO>>(collectionModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyInfoDTO> findById(@PathVariable("id") Long id) {
        PropertyInfo info = propertyInfoService.findById(id);
        PropertyInfoDTO dto = propertyInfoDTOAssembler.toModel(info);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PropertyInfoDTO> addPropertyInfo(@RequestBody PropertyInfo info) {
        PropertyInfo info2 = propertyInfoService.save(info);
        PropertyInfoDTO dto = propertyInfoDTOAssembler.toModel(info2);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/storedProcedure")
    public ResponseEntity<PropertyInfoDTO> insertPropertyInfo(@RequestBody PropertyInfo info) {
        propertyInfoService.propertyInfoInsetion(info.getOwner().getId(),
                info.getWatch().getSerialNumber());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{propertyInfoId}")
    public ResponseEntity<PropertyInfoDTO> updatePropertyInfo(
            @PathVariable("propertyInfoId") Long propertyInfoId,
            @RequestBody PropertyInfo propertyInfo) {
        PropertyInfo info2 = propertyInfoService.update(propertyInfo, propertyInfoId);
        PropertyInfoDTO dto = propertyInfoDTOAssembler.toModel(info2);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{propertyInfoId}")
    public ResponseEntity<PropertyInfoDTO> deletePropertyInfo(
            @PathVariable("propertyInfoId") Long propertyInfoId) {
        PropertyInfo info2 = propertyInfoService.deleteById(propertyInfoId);
        PropertyInfoDTO dto = propertyInfoDTOAssembler.toModel(info2);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
