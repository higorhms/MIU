package com.miu.persistence;

import com.miu.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("SELECT H FROM Hotel H WHERE H.numberOfRooms > 50")
    public List<Hotel> getAllWithMoreThan50Rooms();

    @Query("SELECT H FROM Hotel H WHERE H.year < ?1")
    public List<Hotel> findAllByYearBefore(int year);

    public List<Hotel> findAllByYearAndNumberOfRooms(int year, int numberOfRooms);

    @Query("SELECT H FROM Hotel H order by H.numberOfLevels desc")
    List<Hotel> findTallest();
}
