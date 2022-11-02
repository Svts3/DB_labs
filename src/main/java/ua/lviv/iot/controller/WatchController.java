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

import ua.lviv.iot.dto.OwnerDTO;
import ua.lviv.iot.dto.WatchDTO;
import ua.lviv.iot.dto.assembler.OwnerDTOAssembler;
import ua.lviv.iot.dto.assembler.WatchDTOAssembler;
import ua.lviv.iot.model.Owner;
import ua.lviv.iot.model.Watch;
import ua.lviv.iot.service.WatchService;

@RestController
@RequestMapping("/api/watch")
public class WatchController {

    private WatchService watchService;
    private WatchDTOAssembler watchDTOAssembler;
    private OwnerDTOAssembler ownerDTOAssembler;

    @Autowired
    public WatchController(WatchService watchService, WatchDTOAssembler watchDTOAssembler,
            OwnerDTOAssembler ownerDTOAssembler) {
        this.watchService = watchService;
        this.watchDTOAssembler = watchDTOAssembler;
        this.ownerDTOAssembler = ownerDTOAssembler;
    }

    @GetMapping("/")
    public ResponseEntity<CollectionModel<WatchDTO>> findAll() {
        List<Watch> watches = watchService.findAll();
        CollectionModel<WatchDTO> collectionModel = watchDTOAssembler.toCollectionModel(watches);
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WatchDTO> findById(@PathVariable("id") String id) {
        Watch watch = watchService.findById(id);
        WatchDTO dto = watchDTOAssembler.toModel(watch);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{serialNumber}/owners")
    public ResponseEntity<CollectionModel<OwnerDTO>> findAllWatchOwnersBySerialNumber(
            @PathVariable(name = "serialNumber", required = true) String serialNumber) {
        List<Owner> owners = watchService.findAllWatchOwnersBySerialNumber(serialNumber);
        CollectionModel<OwnerDTO> collectionModel = ownerDTOAssembler.toCollectionModel(owners);
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<WatchDTO> addWatch(@RequestBody Watch watch) {
        Watch watch2 = watchService.save(watch);
        WatchDTO dto = watchDTOAssembler.toModel(watch2);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<WatchDTO> updateOwner(@PathVariable("serialNumber") String serialNumber,
            @RequestBody Watch watch) {
        Watch watch2 = watchService.update(watch, serialNumber);
        WatchDTO dto = watchDTOAssembler.toModel(watch2);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{serialNumber}")
    public ResponseEntity<WatchDTO> deleteOwner(@PathVariable("serialNumber") String serialNumber) {
        Watch watch2 = watchService.deleteById(serialNumber);
        WatchDTO dto = watchDTOAssembler.toModel(watch2);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
