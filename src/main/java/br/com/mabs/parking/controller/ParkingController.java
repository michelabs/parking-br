package br.com.mabs.parking.controller;

import br.com.mabs.parking.controller.mapper.ParkingMapper;
import br.com.mabs.parking.dto.ParkingDTO;
import br.com.mabs.parking.model.Parking;
import br.com.mabs.parking.service.impl.ParkingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingServiceImpl parkingService;
    private ParkingMapper parkingMapper;

    public ParkingController (ParkingServiceImpl parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public List<ParkingDTO> findAll() {
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return result;
    }

}
