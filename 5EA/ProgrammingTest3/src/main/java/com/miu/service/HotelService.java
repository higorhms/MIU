package com.miu.service;

import com.miu.entities.Hotel;
import com.miu.persistence.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    public Hotel createOne(Hotel hotel){
        return this.hotelRepository.save(hotel);
    }

    public List<Hotel> getAll(){
        return this.hotelRepository.findAll();
    }

    public Hotel getOne(int hotelId) {
        return this.hotelRepository.findById(hotelId).get();
    }

    public List<Hotel> getAllByRoomAndYear(int numberOfRooms, int year) {
        return this.hotelRepository.findAllByYearAndNumberOfRooms(year, numberOfRooms);
    }

    public void deleteOne(int hotelId) {
        this.hotelRepository.deleteById(hotelId);
    }

    public List<Hotel> getAllWithMoreThan50Rooms() {
        return this.hotelRepository.getAllWithMoreThan50Rooms();
    }

    public List<Hotel> getAllBuiltBefore(int year) {
        return this.hotelRepository.findAllByYearBefore(year);
    }

    public Hotel getTallest(){
        return this.hotelRepository.findTallest().get(0);
    }

    public Hotel updateOne(int hotelId, Hotel hotel) {
        hotel.setId(hotelId);
        return this.hotelRepository.save(hotel);
    }
}
