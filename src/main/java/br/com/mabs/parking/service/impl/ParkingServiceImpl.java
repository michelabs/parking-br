package br.com.mabs.parking.service.impl;

import br.com.mabs.parking.model.Parking;
import br.com.mabs.parking.service.ParkingService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id  = getUUID();
        Parking parking = new Parking(id, "ABC-1234", "SC", "CELTA", "PRETO");
        parkingMap.put(id, parking);
    }

    //generating ID like a Hashcode
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Parking create() {
        return null;
    }

    @Override
    public Parking update(Parking parking) {
        return null;
    }

    @Override
    public Parking findById(Long id) {
        return null;
    }

    @Override
    public Parking deleteById(Long id) {
        return null;
    }
}
