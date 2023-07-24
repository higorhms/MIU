package com.miu.controller;

import com.miu.entities.Hotel;
import com.miu.service.HotelService;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping("")
    public List<Hotel> getAll(){
        return this.hotelService.getAll();
    }

    @GetMapping("/{hotelId}")
    public Hotel getOne(@PathVariable int hotelId){
        return this.hotelService.getOne(hotelId);
    }

    @PutMapping("/{hotelId}")
    public Hotel updateOne(@PathVariable int hotelId, @RequestBody Hotel hotel){
        return this.hotelService.updateOne(hotelId, hotel);
    }

    @GetMapping("/filter")
    public List<Hotel> getAllByRoomsAndYear(@RequestParam int numberOfRooms, @RequestParam int year ){
        return this.hotelService.getAllByRoomAndYear(numberOfRooms, year);
    }

    @PostMapping("")
    public Hotel createOne(@RequestBody Hotel hotel){
        return this.hotelService.createOne(hotel);
    }

    @DeleteMapping("/{hotelId}")
    public void deleteOne(@PathVariable int hotelId){
        this.hotelService.deleteOne(hotelId);
    }

    @GetMapping("/moreThan50Rooms")
    public List<Hotel> getAllWithMoreThan50Rooms(){
        return this.hotelService.getAllWithMoreThan50Rooms();
    }

    @GetMapping("/builtBefore/{year}")
    public List<Hotel> getAllBuiltBefore(@PathVariable int year){
        return this.hotelService.getAllBuiltBefore(year);
    }

    @GetMapping("/tallest")
    public Hotel findTallest(){
        return this.hotelService.getTallest();
    }
}
