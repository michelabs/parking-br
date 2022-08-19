package br.com.mabs.parking.service;

import br.com.mabs.parking.model.Parking;

import java.util.List;

public interface ParkingService {

    List<Parking> findAll();
    Parking create();
    Parking update(Parking parking);
    Parking findById(Long id);
    Parking deleteById(Long id);

}
