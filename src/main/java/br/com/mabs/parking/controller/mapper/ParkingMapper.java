package br.com.mabs.parking.controller.mapper;

import br.com.mabs.parking.dto.ParkingDTO;
import br.com.mabs.parking.dto.ParkingDTOCreate;
import br.com.mabs.parking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO toParkingDTO(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }
    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }

    public Parking toParking(ParkingDTO parkingDTO) {
        return MODEL_MAPPER.map(parkingDTO, Parking.class);
    }

    public Parking toParkingCreate(ParkingDTOCreate parkingDTO) {
        return MODEL_MAPPER.map(parkingDTO, Parking.class);
    }
}
