package br.com.mabs.parking.service.impl;

import br.com.mabs.parking.model.Parking;
import br.com.mabs.parking.service.ParkingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    //generating ID like a Hashcode
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    @Override
    public Parking update(Parking parking) {
        return null;
    }

    @Override
    public Parking findById(String id) {
        return parkingMap.get(id) ;
    }

    @Override
    public Parking deleteById(Long id) {
        return null;
    }

}
