package com.msstudent.ie.carbonfree.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    @Query("SELECT DISTINCT cityName FROM City ")
    List<String> findAllCityName();

    @Query("SELECT c FROM City c WHERE c.cityName =:cityName")
    List<City> findByCityName(String cityName);

}
