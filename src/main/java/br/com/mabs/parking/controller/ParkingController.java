package br.com.mabs.parking.controller;

import br.com.mabs.parking.controller.mapper.ParkingMapper;
import br.com.mabs.parking.dto.ParkingDTO;
import br.com.mabs.parking.dto.ParkingDTOCreate;
import br.com.mabs.parking.model.Parking;
import br.com.mabs.parking.service.impl.ParkingServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {
    @Autowired
    private ParkingServiceImpl parkingService;
    private ParkingMapper parkingMapper;

    public ParkingController (ParkingServiceImpl parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find parking by id")
    public ResponseEntity<ParkingDTO> parkingById (@PathVariable String id) {
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create")
    @ApiOperation("Creating a new parking")
    public ResponseEntity<ParkingDTO> createParking(@RequestBody ParkingDTOCreate parkingDTO) {
        Parking parkingCreate = parkingMapper.toParkingCreate(parkingDTO);
        Parking parking= parkingService.create(parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(result);
    }

}
